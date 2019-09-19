package com.wxs.controller;

import com.wxs.exception.MyException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Author: WuXiangShuai
 * @Time: 11:32 2019/8/29.
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/helloerror")
//    @ResponseBody
    public String helloerror(){
        if (true) {
            throw new MyException();
        }
        return "helloerror";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/toSuccess")
    public String toSuccess(Map<String, Object> param){
        param.put("hello", "你好！");
        List<String> list = new ArrayList<>();
        list.add("wxs");
        list.add("123");
        list.add("456");
        param.put("users", list);
        return "success";
    }

    @Bean
    public ViewResolver myView(){
        return new MyViewSolver();
    }

    private static class MyViewSolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
