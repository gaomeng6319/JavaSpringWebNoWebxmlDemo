package com.wying.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**相当于spring-mvc.xml文件
 * description:spring提供了使用代码去除 spring-mvc.xml配置文件的方式
 * 、。。既然servlet3.0 开始都去除web.xml了 spring也提供了一套去除自家xml配置的方法
 * 该class通过代码配置spring-mvc.xml的内容
 * date: 2021/3/19
 * author: gaom
 * version: 1.0
 */

@Configuration
@EnableWebMvc  //开启支持mvc
@ComponentScan(basePackages = "com.wying")
public class MySpringMvcXml {

    /**
     * 代替spring-mvc.xml
     * <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
