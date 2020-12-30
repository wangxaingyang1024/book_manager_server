package com.bookmanager.comment.service.impl;

import com.bookmanager.comment.dto.IsClickDTO;
import com.bookmanager.setting.model.Comment;
import com.bookmanager.comment.dto.RComment;
import com.bookmanager.comment.mapper.CommentMapper;
import com.bookmanager.comment.service.CommentService;
import com.bookmanager.setting.util.DisposeNumber;
import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private EmployeeMapper employeeMapper ;

    //添加评论
    @Override
    public Result addComment(Comment comment) {
        String mFlag = DisposeNumber.NumberUUID(5);
        String isExist = commentMapper.findMFlagByIsExist(mFlag);
        if(!StringUtils.isEmpty(isExist)){
             addComment(comment);
        }
        if(StringUtils.isEmpty(isExist) && comment.getParFlag() != null){
//            if("0".equals(comment.getParFlag())){
//                comment.setParFlag("0"); //当为父节点时，自动生成。
//             }
            comment.setCommentTime(new Date());
            comment.setMyFlag(mFlag); //当为根节点的时候的自己的信息标识
            commentMapper.addComment(comment);
            return new Result(CodeEnum.COMMENT_ADD_SUCCESS);
        }
        return new Result(CodeEnum.SELECT_FAILED);
    }

    //更新点赞
    @Override
    public Result updateComment(IsClickDTO clickDTO) {
        Integer likeCount = commentMapper.getCommentByMyFlag(clickDTO.getMyFlag());
        if(likeCount == null){
            return new Result(CodeEnum.SELECT_FAILED);
        }
        if(clickDTO.getIsLike()){
            likeCount++;
            //添加中间表
            personalAdditionLike(clickDTO);
        }else {
            if(likeCount <= 0 ){
                likeCount = 0 ;
            }else {
                likeCount--;
                personalDeleteLike(clickDTO);
            }
        }
        clickDTO.setLikeCount(likeCount);
        commentMapper.updateComment(clickDTO);
        return new Result(CodeEnum.COMMENT_LIKE_SUCCESS);
    }

    /**
     * 查询评论列表
     * @param isClickDTO
     * @return
     */
    @Override
    public Result findEnd(IsClickDTO isClickDTO) {
        //根节点
        List<RComment> byParFlag = commentMapper.getCommentByParFlag("0", isClickDTO.getIsbn());
        for (int i = 0; i < byParFlag.size(); i++) {
            List<RComment> rComments = commentList(byParFlag, i);
            for (int y = 0; y < rComments.size(); y++) {
                commentList(rComments, y);
            }
        }
    return new Result(CodeEnum.COMMENT_Find_SUCCESS,byParFlag);
    }

    /**
     * comment代码抽取
     * @param commentList
     * @param i
     * @return
     */
    private List<RComment> commentList(List<RComment> commentList,Integer i){
        String nickname = employeeMapper.getNicknameByJobNumber(commentList.get(i).getMyNumber());
        commentList.get(i).setMyNickname(nickname);
        List<RComment> childrenT = commentMapper.selectByParFlag(commentList.get(i).getMyFlag());
        for (int x = 0; x < childrenT.size(); x++) {
            String nickName = employeeMapper.getNicknameByJobNumber(childrenT.get(x).getMyNumber());
            childrenT.get(x).setMyNickname(nickName);
            String nick = employeeMapper.getNicknameByJobNumber(childrenT.get(x).getParNumber());
            childrenT.get(x).setParNickname(nick);
        }
        commentList.get(i).setChildren(childrenT);
        return childrenT ;
    }

    @Override
    public Result personalList(IsClickDTO personal) {
        return new Result(CodeEnum.SELECT_SUCCESS,commentMapper.selectLikeByJobNumberAndIsbn(personal));
    }

    @Override
    public Result personalAdditionLike(IsClickDTO personal) {
        return new Result(CodeEnum.SELECT_SUCCESS,commentMapper.insertPersonalLike(personal));
    }

    @Override
    public Result personalDeleteLike(IsClickDTO personal) {
        return new Result(CodeEnum.SELECT_SUCCESS,commentMapper.removePersonalLike(personal));
    }
}
