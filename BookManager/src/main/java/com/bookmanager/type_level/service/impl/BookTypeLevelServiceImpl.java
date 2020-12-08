package com.bookmanager.type_level.service.impl;

import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.util.RandomNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.mapper.BookTypeLevelMapper;
import com.bookmanager.type_level.service.IBookTypeLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookTypeLevelServiceImpl implements IBookTypeLevelService {

    @Resource
    private BookTypeLevelMapper levelMapper ;

    /**
     * 增加图书类型
     * @param bookTypeLevel
     * @return
     */
    @Override
    public Result addBookType(BookTypeLevel bookTypeLevel) {
        String name = levelMapper.selectByName(bookTypeLevel.getName());
        if(name != null){
            return new Result(CodeEnum.TYPE_EXIST);
        }
        Integer mid = levelMapper.selectMidByMid(Integer.parseInt(RandomNumber.NumberUUID(4)));
        if(mid != null){
            addBookType(bookTypeLevel);
        }
        try {
            bookTypeLevel.setMyId(Integer.parseInt(RandomNumber.NumberUUID(4)));
            levelMapper.insert(bookTypeLevel);
            return new Result(CodeEnum.SELECT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.ADD_FAILED);
    }
}
