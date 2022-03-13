package com.xxxx.service;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/*
* 业务逻辑
* */
public class UserService {
    /*      用户登录
    service (业务逻辑)
                                1.参数的非空判断
                                    如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象

                                2.调用dao层的查询方法，通过用户名查询用户对象

                                3.判断用户对象是否为空
                                    如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象

                                4.判断数据库中查询到的用户密码与前台传递过来的用户密码
                                    不等，则将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象

                                5.登录成功
                                        将成功状态码、提示信息、用户对象 设置到消息模型对象中，并返回
    *
    * */
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();
        //回显数据
        User u = new User();
        u.setUerName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);


        // 1.参数的非空判断
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            //如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMessage("用户姓名和密码不能为空！");

            return messageModel;
        }

        //2.调用dao层的查询方法，通过用户名查询用户对象
            SqlSession session = GetSqlSession.createSqlSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.queryUserByName(uname);


        //3.判断用户对象是否为空
            if(user == null){
                //如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
                messageModel.setCode(0);
                messageModel.setMessage("用户不存在！");

                return messageModel;
            }

         //4.判断数据库中查询到的用户密码与前台传递过来的用户密码
            if(!upwd.equals(user.getUserPwd())){
                messageModel.setCode(0);
                messageModel.setMessage("用户密码不正确！");
                return messageModel;
            }


        //5.登录成功，将用户信息设置到用户模型中
        messageModel.setObject(user);

        return messageModel;
    }
}
