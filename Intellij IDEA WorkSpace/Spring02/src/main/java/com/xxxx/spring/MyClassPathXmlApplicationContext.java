package com.xxxx.spring;

/* 实现MyFactory接口 */

/*
*       模拟spring的实现
*           1.通过带参构造器得到对应的配置文件
*           2.通过 dom4j 解析 配置文件(xml) 得到List集合， 其中存放bean标签的 id 和 class
*           3.通过反射 得到对应的实例化对象，放置在Map对象中 （遍历List集合，通过获取对应的class属性，利用class.forName(class).newInstance() ）
*           4.通过id属性值，获取指定的实例化对象
* */

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClassPathXmlApplicationContext implements MyFactory{

    private List<MyBean> beanList; // List集合 ，存放从配置文件读取的（bean标签的）配置信息 （id / class） MyBean代表是每个bean标签
    private Map<String,Object> beanMap = new HashMap<>(); //存放实例化好的对象，通过id获取对应的对象




    //1.通过带参构造器得到对应的配置文件
    public MyClassPathXmlApplicationContext(String fileName) {

        /* 2.通过 dom4j 解析 配置文件(xml) 得到List集合 */
        this.parseXml(fileName);  //parseXml() 解析

        /*3.通过反射 得到对应的实例化对象，放置在Map对象中*/
        this.instanceBean();

    }

    private void instanceBean() {
    }


    /**
     * 通过 dom4j 解析 配置文件(xml) 得到List集合
     *          1.获取解析器
     *          2.获取配置文件的url
     *          3.通过解析器 解析 配置文件  xml
     *          4.通过xpath语法解析，获取对应的beans标签下的所有bean标签
     *          5.通过指定的解析语法解析当前的文档对象，返回元素集合
     *          6.判断元素集合是否为空
     *          7.如果元素集合不为空，遍历集合
     *          8.获取bean标签元素的属性  id 和 class属性值
     *          9.将获取Mybean对象，将id和class属性值 设置到对象中，再将对象设置到Mybean集合中
     * @param fileName
     */
    private void parseXml(String fileName) {
                //1.获取解析器
        SAXReader saxReader = new SAXReader();
                // 2.获取配置文件的url
        URL url = this.getClass().getClassLoader().getResource(fileName);

        try {
            //3.通过解析器 解析 配置文件  xml
            Document document = saxReader.read(url);

            //4.通过xpath语法解析，获取对应的beans标签下的所有bean标签
            XPath xPath = document.createXPath("beans/bean");

            //5.通过指定的解析语法解析当前的文档对象，返回元素集合
            List<Element> elementList = xPath.selectNodes(document);

            //6.判断元素集合是否为空
            if(elementList != null && elementList.size()>0){

                //实例化beanlist
                beanList = new ArrayList<>();

                //7.如果元素集合不为空，遍历集合
                for (Element el:elementList) {
                    // 8.获取bean标签元素的属性  id 和 class属性值
                    String id = el.attributeValue("id");    //id
                    String clazz = el.attributeValue("class"); //class

                    //9.将获取Mybean对象，将id和class属性值 设置到对象中，再将对象设置到Mybean集合中
                    MyBean myBean = new MyBean(id,clazz);
                    beanList.add(myBean);

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /*
    *      通过id获取对应map对象中的value
    * */

    @Override
    public Object getBean(String id) {
        Object object = beanMap.get(id);
        return object;
    }
}
