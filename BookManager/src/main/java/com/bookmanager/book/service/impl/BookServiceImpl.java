package com.bookmanager.book.service.impl;

import com.bookmanager.book.mapper.BookMapper;
import com.bookmanager.book.service.BookService;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getBook(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有图书
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        return bookMapper.findAllBook();
    }

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        Book book1 = bookMapper.getBookIsbn(MYISBN());
        if (book1 != null) {
            addBook(book);
        }
        return bookMapper.insertBook(book);
    }

    /**
     * 删除图书
     *
     * @param isbn
     * @return
     */
    @Override
    public int deleteBookByIsbn(long isbn) {
      Book book = bookMapper.findBookByIsbn(isbn);
      if(book != null){
          return bookMapper.deleteBookByIsbn(isbn);
      }
      return 0;
    }

    /**
     * 更新图书
     * @param isbn
     * @return
     */
    @Override
    public Result updateBook(Long isbn) {
        Book book = bookMapper.findBookByIsbn(isbn);
        if(book == null){
            return new Result(CodeEnum.BOOK_UPDATE_FAILED);
        }
        //todo:更新
        return new Result(CodeEnum.BOOK_UPDATE_SUCCESS);
    }

    /**
     * 借书
     * @param isbn
     * @return
     */
    @Override
    public int borrowBook(Long isbn) {
        return bookMapper.deleteBookByIsbn(isbn);
    }

    /**
     * 还书
     * @param isbn
     * @return
     */
    @Override
    public int returnBook(Long isbn) {

        return 0;
    }
    /**
     *随机生成图书编号isbn
     */
    public static long MYISBN(){
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
