package com.atguigu.mvc.controller;

//包controller是控制器

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*标注 + 扫描 ==== bean进行管理*/

//绿色图标 标识已经交给ioc容器进行管理了
@Controller
public class HelloController {

    // 请求路径 '/'  -> /WEB-INF/templates/index.html

    @RequestMapping("/")
    public String index(){
        //返回视图名称
        return "index";

    }

}
