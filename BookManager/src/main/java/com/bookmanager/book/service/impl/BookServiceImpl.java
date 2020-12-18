package com.bookmanager.book.service.impl;

import com.bookmanager.book.dto.BookListDTO;
import com.bookmanager.book.dto.BookTypeDTO;
import com.bookmanager.book.dto.RelationBookEmpDTO;
import com.bookmanager.book.mapper.BookMapper;
import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.mapper.BookTypeLevelMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.*;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private static final Integer ROOT_LEVEL = 1 ;
    private static final Integer SECOND_LEVEL =2 ;
    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookTypeLevelMapper typeLevelMapper ;

    @Override
    public Result querySort() {
        List<String> type = bookMapper.selectTypeByType();
        return new Result(CodeEnum.SELECT_SUCCESS,type);
    }

    /**
     * 管理员查询图书
     *
     * @return
     */
    @Override
    public Result findAdminAllBook(String name ,Integer pageNum , Integer pageSize) {
        if(!"".equals(name)) {
            String n = "%"+name+"%";
            PageHelper.startPage(pageNum, pageSize);
            List<BookListDTO> books = bookMapper.selectLikeName(n);
            PageInfo<BookListDTO> pageInfo = new PageInfo<>(books);
            return new Result(CodeEnum.FIND_BOOKS,pageInfo);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BookListDTO> listDTOS = bookMapper.findAdminAllBook();
        for (int x = 0; x < listDTOS.size(); x++) {
            Long isbn = listDTOS.get(x).getIsbn();
            Integer type = bookMapper.findBookByIsbn(isbn).getType();
            Integer[] allTid = findAllTid(type);
            listDTOS.get(x).setLevel(allTid);
        }
        PageInfo<BookListDTO> pageInfo = new PageInfo<>(listDTOS);
        return new Result(CodeEnum.FIND_BOOKS, pageInfo);
    }

    /**
     * 获取三级id组成数组
     * @param type
     * @return
     */
    private Integer[] findAllTid(Integer type){
        Integer[] level = new Integer[3];
        level[2] = type ;
        Integer level2 = typeLevelMapper.selectPidByMid(type);
        level[1] = level2 ;
        level[0] =typeLevelMapper.selectPidByMid(level2);
        return level ;
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
        Book b = bookMapper.getBookIsbn(Long.parseLong(DisposeNumber.NumberUUID(9)));
        if (b != null) {
            addBook(book);
        }
        book.setIsbn(Long.parseLong(DisposeNumber.NumberUUID(9)));
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
        List<BookListDTO> books = bookMapper.FindByEmpNumber(jobNumber);
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
    public Result getListType(Integer level) {
    List<BookTypeDTO> twoNode = typeLevelMapper.selectBookByLevel(SECOND_LEVEL);
    List<BookTypeDTO> oneNode = typeLevelMapper.selectBookByLevel(ROOT_LEVEL);
        if(level == 1){
            return new Result(CodeEnum.SELECT_SUCCESS,oneNode);
        }
        if(level == 2){
            return new Result(CodeEnum.SELECT_SUCCESS,getOneType(oneNode));
        }
        if(level == 3){
            List<BookTypeDTO> tType = getOneType(twoNode);
            for(int x = 0 ; x <oneNode.size() ; x ++){
                List<BookTypeDTO> bookTypeDTOS = new ArrayList<>();
                Integer mid = oneNode.get(x).getMid();
                for (int y = 0 ; y < tType.size() ; y ++){
                    Integer pid = tType.get(y).getPid();
                    if(pid.equals(mid)){
                        bookTypeDTOS.add(tType.get(y));
                    }
                }
                oneNode.get(x).setChildren(bookTypeDTOS);
            }
            return new Result(CodeEnum.SELECT_SUCCESS,oneNode);
        }
        return new Result(CodeEnum.SELECT_FAILED);
    }

    /**
     * 获取二级类型
     * @param nodeT
     * @return
     */
    private List<BookTypeDTO> getOneType(List<BookTypeDTO> nodeT){
        for(int x = 0 ; x<nodeT.size(); x ++) {
            Integer mid = nodeT.get(x).getMid();
            List<BookTypeDTO> children = typeLevelMapper.selectBookTypeByPid(mid); //根据一个pid获取当前pid下的所有子节点
            nodeT.get(x).setChildren(children);
        }
        return nodeT;
    }
}
