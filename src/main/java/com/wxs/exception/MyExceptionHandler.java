package com.wxs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyExceptionHandler
 * @Author: WuXiangShuai
 * @Time: 14:44 2019/9/2.
 * @Description:
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(TemplateInputException.class)
    public String error(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "吴相帅测试错误code");
//        map.put("msg", e.getMessage());
        map.put("message", "嘿嘿");
        e.printStackTrace();
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("ext", map);
        return "forward:/error";
    }

}
