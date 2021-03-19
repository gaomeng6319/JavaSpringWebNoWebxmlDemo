package com.wying.web;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * description:编写实现类 实现WebApplicationInitializer
 * 这样tomcat启动时 先执行SpringServletContainerInitializer.class的onStartup方法
 * 在通过HandlesTypes配置 执行该class的onStartup方法
 * date: 2021/3/19
 * author: gaom
 * version: 1.0
 */

public class MySpringInitializer  implements WebApplicationInitializer {
    //spring配置文件也去除的方式
  /*  @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("=========MySpringInitializer onStartup============");
        System.out.println("=========MySpringInitializer 启动spring容器============");
         // 代替 web.xml 中的 listener 初始化
         //<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        AnnotationConfigWebApplicationContext ac_spring = new AnnotationConfigWebApplicationContext();
        // listener中的加载spring.xml的配置文件内容 MySpringXml.class代替 spring.xml
        ac_spring.register(MySpringXml.class);
        //用于初始化spring配置文件 web项目可用可不用

        servletContext.addListener(new ContextLoaderListener(ac_spring));
        System.out.println("=========MySpringInitializer 配置srping  dispatcherServlet============");
        AnnotationConfigWebApplicationContext ac_mvc = new AnnotationConfigWebApplicationContext();
        //MySpringMvcXml.class代替 spring-mvc.xml
        ac_mvc.register(MySpringMvcXml.class);
        //用于初始化spring配置文件 web项目可用可不用

        //配置spring dispatcherServlet  代替web.xml
        // <servlet-name>springDispatcher</servlet-name>
        //<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac_mvc);
        //创建前端控制器去名字为dispatcherServlet  <servlet>标签
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        //启动顺序设置为1 tomcat启动时就初始化该servlet
        registration.setLoadOnStartup(1);
        //<servlet-mapping>里面的url-patten
        registration.addMapping("*.do");
        System.out.println("=========MySpringInitializer onStartup 运行完毕============");

    }*/

    //读取spring.xml 配置文件的方式
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("保留spring.xml方式=========MySpringInitializer onStartup============");
        System.out.println("=========MySpringInitializer 启动spring容器============");
        servletContext.setInitParameter("contextConfigLocation","classpath:spring.xml");
        //springMVC的servlet
         //添加监听
        servletContext.addListener(new ContextLoaderListener());

        System.out.println("=========MySpringInitializer 配置srping  dispatcherServlet============");
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.do");
        dispatcher.setInitParameter("contextConfigLocation","classpath:spring-mvc.xml");

        System.out.println("=========MySpringInitializer onStartup 运行完毕============");

    }
}
