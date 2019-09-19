package com.wxs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginHandlerInterceptor
 * @Author: WuXiangShuai
 * @Time: 10:26 2019/9/2.
 * @Description:
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取认证参数
        Object user = request.getSession().getAttribute("loginUser");
        if (null == user) {
            // 未登录，返回登录页面
            request.setAttribute("msg", "请登录...");
            request.getRequestDispatcher("login").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

}
