package com.bookmanager.setting.interceptor;

import com.bookmanager.setting.vo.CodeEnum;
import com.bookmanager.setting.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class BookManagerException {
    /*拦截所有的Exception，做统一处理*/
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest req , Exception e) throws Exception {
        log.error("Request URL : {}, Exception : {}",req.getRequestURL(),e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw  e;
        }
        return new Result(CodeEnum.SELECT_FAILED);
    }
}
