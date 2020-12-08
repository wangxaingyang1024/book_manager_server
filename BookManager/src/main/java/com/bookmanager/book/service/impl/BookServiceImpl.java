package com.bookmanager.book.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bookmanager.book.dto.BookTypeDTO;
import com.bookmanager.book.dto.RelationBookEmpDTO;
import com.bookmanager.book.mapper.BookMapper;
import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private static final Integer STATUS = 1 ;
    private static final Integer ROOT_LEVEL = 1 ;
    private static final Integer SECOND_LEVEL =2 ;
    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getBook(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 管理员查询图书
     *
     * @return
     */
    @Override
    public Result findAdminAllBook() {
        return new Result(CodeEnum.FIND_BOOKS,bookMapper.findAdminAllBook());
    }

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @Override
    public Result addBook(Book book) {
        Book book1 = bookMapper.getBookIsbn(book.getIsbn());
        if (book1 != null) {
            return new Result(CodeEnum.BOOK_ADD_FAILED);
        }
        Book b = bookMapper.getBookIsbn(randomIsbn());
        if (b != null) {
            addBook(book);
        }
        book.setIsbn(randomIsbn());
        return new Result(CodeEnum.BOOK_ADD_SUCCESS,bookMapper.insertBook(book));
    }
    /**
     * 删除图书
     *
     * @param isbn
     * @return
     */
    @Override
    public Result deleteBookByIsbn(Long isbn) {
      Book book = bookMapper.findBookByIsbn(isbn);
      if(book != null){
          bookMapper.deleteBookByIsbn(isbn);
          return new Result(CodeEnum.BOOK_DELETE_SUCCESS);
      }
      return new Result(CodeEnum.BOOK_DELETE_FAILED);
    }

    /**
     *更新书
     * @param book
     * @return
     */
    @Override
    public Result updateBook(Book book) {
        Book b = bookMapper.findBookByIsbn(book.getIsbn());
        if(b == null){
            return new Result(CodeEnum.BOOK_UPDATE_FAILED);
        }
        //更新
        int i = bookMapper.updateBook(book);
        if (i == 0 ){
            return new Result(CodeEnum.BOOK_UPDATE_FAILED);
        }
        return new Result(CodeEnum.BOOK_UPDATE_SUCCESS);
    }

    /**
     * 查询某用户的借书信息
     * @return
     */
    @Override
    public Result findByEmpNumber(int jobNumber) {
        List<Book> books = bookMapper.FindByEmpNumber(jobNumber);
        if(books ==null){
            return new Result(CodeEnum.BOOK_find_FAILED);
        }
        return new Result(CodeEnum.SELECT_SUCCESS,books);
    }

    /**
     * 借书
     * @param rbed
     * @return
     */
    @Override
    public Result borrowBook(RelationBookEmpDTO rbed) {
        Book book = bookMapper.findBookByIsbn(rbed.getIsbn());
        if(book == null && book.getStatus() == false){
            return new Result(CodeEnum.BOOK_BORROW_FAILED);
        }
        try {
            bookMapper.borrowBookByIsbn(rbed.getIsbn());
            rbed.setCurrentTime(new Date());
            bookMapper.insertLog(rbed);
            bookMapper.insertRelation(rbed);
            return new Result(CodeEnum.BOOK_BORROW_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.BOOK_BORROW_FAILED);
    }

    /**
     * 还书
     * @param rbed
     * @return
     */
    @Override
    public Result returnBook(RelationBookEmpDTO rbed) {
        Book book = bookMapper.findBookByIsbn(rbed.getIsbn());
        if(book == null && book.getStatus() == true){
            return new Result(CodeEnum.BOOK_RETURN_FAILED);
        }
        try {
            bookMapper.returnBookByIsbn(rbed.getIsbn());
            rbed.setCurrentTime(new Date());
//        bookMapper.selectIsbnByLog(rbed.getIsbn());
            bookMapper.updateReturnTime(rbed);
            bookMapper.deleteLogByJobNumberAndIsbn(rbed);
            return new Result(CodeEnum.BOOK_RETURN_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.BOOK_RETURN_FAILED);
    }


    /**
     * 查詢圖書類型
     * @return
     */

    @Override
    public Result getListType() {
        List<BookTypeDTO> twoNode = bookMapper.selectBookByLevel(ROOT_LEVEL);
        List<BookTypeDTO> oneNode = bookMapper.selectBookByLevel(SECOND_LEVEL);
        List<BookTypeDTO> tType = getOneType(twoNode);
        for(int x = 0 ; x <oneNode.size() ; x ++){
            ArrayList<BookTypeDTO> bookTypeDTOS = new ArrayList<>();
            Integer mid = oneNode.get(x).getMid();
            for (int y = 0 ; y < tType.size() ; y ++){
                if(mid == tType.get(y).getPid()){
                    bookTypeDTOS.add(tType.get(y));
                }
            }
            oneNode.get(x).setChildren(bookTypeDTOS);
        }
        return new Result(CodeEnum.SELECT_SUCCESS,oneNode);
    }

    /**
     * 获取二级类型
     * @param nodeT
     * @return
     */
    private List<BookTypeDTO> getOneType(List<BookTypeDTO> nodeT){
        for(int x = 0 ; x<nodeT.size(); x ++) {
            Integer mid = nodeT.get(x).getMid();
            List<BookTypeDTO> children = bookMapper.selectBookTypeByPid(mid); //根据一个pid获取当前pid下的所有子节点
            nodeT.get(x).setChildren(children);
        }
        return nodeT;
    }

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Override
    public Result selectLike(String name) {
        String n = "%"+name+"%";
        return new Result(CodeEnum.SELECT_SUCCESS,bookMapper.selectLikeName(n));
    }



    /**
     *随机生成图书编号isbn
     */
    public static long randomIsbn(){
        String isbnStr = "";
        for (int i=0;i<9;i++){
            int random = (int) (Math.random() * 9);
            if (isbnStr.indexOf(random + "") != -1) {
                i = i - 1;
            } else {
                isbnStr += random;
            }
        }
        return Long.valueOf(isbnStr);
    }


}
