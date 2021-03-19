package com.wying.web;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 相当于spring.xml文件
 * description:spring提供了使用代码去除 spring.xml配置文件的方式
 * 、。。既然servlet3.0 开始都去除web.xml了 spring也提供了一套去除自家xml配置的方法
 * 该class通过代码配置xml的内容
 * date: 2021/3/19
 * author: gaom
 * version: 1.0
 */

@Configuration
@ComponentScan(basePackages = "com.wying")
public class MySpringXml {


    //目前测试效果 不连接数据库
    // 配置datasource sessionFactory 也一样 通过@Bean注解 规则都差不多 xml的配置 都有对应的class method对应
}
