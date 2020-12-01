package com.bookmanager.setting.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Create by Berton on  19:17.
 * email ：blovesheep@126.com
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

//    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //不拦截路径（登录路径等等）
//        List<String> asList = Arrays.asList("/user/registered", "/user/login", "/fastDFS/**");
//
//        String uri = request.getRequestURI();
//        //1.设置放行路径
//        if(asList.contains(uri)){
//            return true;
//        }
//
//        //2.拿到请求头里面的token（如果是第一次登录，那么是没有请求头的）
//        String token = request.getHeader("u-token");
//        if(token==null){
//            response.setContentType("application/json; charset=utf-8");
//
//            //2.1 拦截请求并返回信息给前台 （前台后置拦截器就是根据这里面返回的json数据，来判读并跳转到登录界面）
//            response.getWriter().print("{\"success\":false,\"msg\":\"NoUser\"}");
//            return false;
//        }
//
//        //3、如果有token，那么就根据这个token从redis查询登录用户信息，如果redis里面还没过期，那么就正常放行，没有就进行拦截，并返回信息，叫他重新登录
//        String tokenUser = RedisUtils.INSTANCE.get(token);
//        if(tokenUser==null){
//            response.setContentType("application/json; charset=utf-8");
//
//            response.getWriter().print("{\"success\":false,\"msg\":\"NoUser\"}");
//            return false;
//        }
//
//        //4.如果没有过期，那么就重新将token和登录用户信息存到redis
//        RedisUtils.INSTANCE.set(token, tokenUser, 60*30);
//
//        return true;
//    }
}
