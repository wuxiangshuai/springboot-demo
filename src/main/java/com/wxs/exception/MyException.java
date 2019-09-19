package com.wxs.exception;

/**
 * @ClassName: MyExecption
 * @Author: WuXiangShuai
 * @Time: 14:42 2019/9/2.
 * @Description:
 */
public class MyException extends RuntimeException {

    private Integer code;
    private String msg;

    public MyException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyException() {
        super("吴相帅测试错误");
    }

    public Integer getCode() {
        return code;
    }

    public MyException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public MyException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
