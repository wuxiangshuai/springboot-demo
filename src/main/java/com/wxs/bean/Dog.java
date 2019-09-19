package com.wxs.bean;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * @ClassName: Dog
 * @Author: WuXiangShuai
 * @Time: 15:28 2019/8/29.
 * @Description:
 */
public class Dog {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Dog setAge(Integer age) {
        this.age = age;
        return this;
    }
}
