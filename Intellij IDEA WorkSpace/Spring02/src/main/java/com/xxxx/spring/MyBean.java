package com.xxxx.spring;

/*
* Bean属性对象
*       用来存放配置文件中 bean标签对应  id 和 class属性值
* */

public class MyBean {
    private String id;      //bean标签的id属性值
    private String clazz;   //bean标签的class属性值

    //提供构造器 constructor

    //空构造
    public MyBean() {
    }
    //带参构造


    public MyBean(String id, String clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    //get和set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
