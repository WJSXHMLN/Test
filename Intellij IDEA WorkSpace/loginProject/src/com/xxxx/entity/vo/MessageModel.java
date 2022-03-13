package com.xxxx.entity.vo;
/*  消息模型对象，做数据响应
        状态码
                1 = 成功
                0 = 失败
         提示信息
                字符串

         回显数据
                object对象
*
* */
public class MessageModel {
    private Integer code = 1;  // 状态码   1 = 成功  0 = 失败
    private String message = "成功";  //提示信息
    private Object object;  //回显数据对象   （基本数据类型，字符串，list , map等）




    /* alt + insert get 和 set 方法*/

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
