package com.xxxx.service;

import com.xxxx.dao.UserDao;

public class UserService {
    public static void testService(){
        System.out.println("UserService test......");
        //maven_service 调用 maven_dao层的方法   (service要引入dao的依赖)
        UserDao.testDao();
    }
}
