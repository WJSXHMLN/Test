package com.xxxx.entity;

//User 实体类
public class User {

    private Integer userId ;    //用户编号
    private String userName;    //用户名称
    private String userPwd;     //用户密码
    private Integer userAge;    //用户年龄

    /*get 和 set 方法 快捷键  alt + insert*/
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUerName() {
        return userName;
    }

    public void setUerName(String uerName) {
        this.userName = uerName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
