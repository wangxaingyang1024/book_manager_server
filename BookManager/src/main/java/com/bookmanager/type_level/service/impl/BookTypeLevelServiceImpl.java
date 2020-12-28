package com.bookmanager.type_level.service.impl;

import com.bookmanager.book.mapper.BookMapper;
import com.bookmanager.setting.model.Book;
import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.dto.BookTypeLevelDTO;
import com.bookmanager.type_level.mapper.BookTypeLevelMapper;
import com.bookmanager.type_level.service.IBookTypeLevelService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@Service
public class BookTypeLevelServiceImpl implements IBookTypeLevelService {

    private static final Integer ONE_LEVEL=1;
    private static final Integer TWO_LEVEL=2;
    private static final Integer THREE_LEVEL=3;

    @Resource
    private BookTypeLevelMapper levelMapper ;

    @Resource
    private BookMapper bookMapper;

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
        Integer mid = levelMapper.selectMidByMid(Integer.parseInt(DisposeNumber.NumberUUID(4)));
        if(mid != null){
            addBookType(bookTypeLevel);
        }
        try {
            bookTypeLevel.setMyId(Integer.parseInt(DisposeNumber.NumberUUID(4)));
            levelMapper.insert(bookTypeLevel);
            return new Result(CodeEnum.SELECT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(CodeEnum.ADD_FAILED);
    }

    /**
     * 根据mid删除当前节点及其子节点
     * @param levelDTO
     * @return
     */
    @Override
    public Result deleteBookType(BookTypeLevelDTO levelDTO) {
        List<Integer> cids = DisposeNumber.StringTransformInteger(levelDTO.getCid()); //每个节点的子集集合
        if(levelDTO.getLevel() == THREE_LEVEL){
            if(threeLevelDelete(levelDTO.getMid())== true){
                return new Result(CodeEnum.SELECT_SUCCESS); //200
            }
            return new Result(CodeEnum.SELECT_FAILED);  //402
        }
        if(levelDTO.getLevel() == TWO_LEVEL){
            return twoLevelDelete(levelDTO.getMid(),cids);
        }
        if(levelDTO.getLevel() == ONE_LEVEL){
            if(cids == null){
                levelMapper.deleteByMid(levelDTO.getMid());
                return new Result(CodeEnum.SELECT_SUCCESS); //200
            }
            //验证二级节点下的每一个节点都可用
            for(int x = 0 ; x < cids.size() ; x ++) { //每一个二级节点
                if(whetherDeleteTwo(cids.get(x)) == false){
                    return new Result(CodeEnum.SELECT_FAILED);  //402
                }
            }
            //操作二级节点及其子节点
            for(int x = 0 ; x < cids.size() ; x ++) { //每一个二级节点
                List<Integer> threeLevel = levelMapper.selectMidBypid(cids.get(x)); // 每个二级节点下的所有三级节点
                if(threeLevel.size() == 0){
                    levelMapper.deleteByMid(cids.get(x));
                }
                for (int i = 0; i < threeLevel.size(); i++) {
                   threeLevelDelete(threeLevel.get(i));
                }
                levelMapper.deleteByMid(cids.get(x));
            }
            levelMapper.deleteByMid(levelDTO.getMid());
            return new Result(CodeEnum.SELECT_SUCCESS); //200
        }
        return new Result(CodeEnum.SELECT_FAILED);  //402
    }
    /**
     * 判断一级级是否可以删除
     * @param twoMid  二级节点下的每一个节点
     * @return
     */
    private Boolean whetherDeleteTwo(Integer twoMid) {
        List<Integer> threeMid = levelMapper.selectMidBypid(twoMid); //获取每个二级节点下的直接子节点集合
        boolean sign = true;
        if(twoMid != null){
            if(threeMid.size() != 0){
                Label:for(int x = 0 ; x< threeMid.size();x ++){ //每一个三级
                    List<Book> b = bookMapper.selectByType(threeMid.get(x));
                    if (b.size() != 0) {
                        for (int y = 0; y < b.size(); y++) {
                            if (b.get(y).getStatus() == false) {
                                sign = false ;
                                break Label;
                            }
                        }
                    }
                }
                return sign ;
            }
        }
        return true ;
    }
    /**
     * 二级删除
     * @param mid  自己的id
     * @param cids  自节子集的id
     * @return
     */
    private Result twoLevelDelete(Integer mid ,List<Integer> cids){

        if(cids == null){
            levelMapper.deleteByMid(mid);
            return new Result(CodeEnum.SELECT_SUCCESS); //200
        }
        //判断是否可以删除
        for(int x = 0 ; x < cids.size() ; x++){
            Boolean wd = whetherDeleteThree(cids.get(x)); //是否能删
            if(wd == false){
                return new Result(CodeEnum.SELECT_FAILED);  //402
            }
        }
        //真正的删除操作
        for(int x = 0 ; x < cids.size() ; x++){
            threeLevelDelete(cids.get(x));
        }
        levelMapper.deleteByMid(mid);
        return new Result(CodeEnum.SELECT_SUCCESS); //200
    }

    /**
     * 三级删除
     * @param mid
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    public Boolean threeLevelDelete(Integer mid){
        List<Book> book = bookMapper.selectByType(mid);
        if(book.size() == 0){
            levelMapper.deleteByMid(mid);
            return true ;
        }
        for(int x = 0 ; x < book.size();x ++) {
            if (book.get(x).getStatus() == false) {
                return true ;
            }
        }
        for(int x = 0 ; x < book.size();x ++) {
            try {
                book.get(x).setType(null);
                int i = bookMapper.updateBook(book.get(x));
                levelMapper.deleteByMid(mid);
            } catch (Exception e) {
                return false ;
            }
        }
        return true ;

    }

    /**
     * 判断三级是否可以删除
     * @param mid
     * @return
     */
    private Boolean whetherDeleteThree(Integer mid) {
        List<Book> book = bookMapper.selectByType(mid);
        boolean flag = true;
        if (book.size() != 0) {
            for (int x = 0; x < book.size(); x++) {
                if (book.get(x).getStatus() == false) {
                    flag = false ;
                    break;
                }
            }
            return flag ;
        }
        return true ;
    }

}
