package com.xxxx.test;

import com.xxxx.service.UserService;
import com.xxxx.service.UserService02;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter01 {
    public static void main(String[] args) {

        //1.得到spring上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        //2.通过id属性值得到指定的bean对象   (默认返回object类型，需要强制转换一下)
        UserService userService = (UserService) ac.getBean("userService");

        //3.调用实例化后的javabean对象中的方法
        userService.test();


        UserService02 userService02 = (UserService02) ac.getBean("userService02");
        userService02.test();
    }
}
