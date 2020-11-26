package com.zjkj.bookmanager;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zjkj.bookmanager.mapper.BookMapper;
import com.zjkj.bookmanager.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BookmanagerApplicationTests {

    @Resource
    private BookMapper bookMapper ;
    @Test
    public void contextLoads() {
        Book book = bookMapper.selectByPrimaryKey(1L);
        System.out.println(book.toString());
    }
}
