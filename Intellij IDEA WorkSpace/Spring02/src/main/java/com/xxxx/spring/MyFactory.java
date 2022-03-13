package com.xxxx.spring;

/*
*       Bean工厂接口的定义
* */
public interface MyFactory {

    //通过id属性值获取bean对象
    public Object getBean(String id);
}
