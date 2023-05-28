package com.study.springbootstudy;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class SpringBootStudyApplication {

    public static void main(String[] args) {
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.registerBean(HelloController.class);
        applicationContext.refresh();

        ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = servletWebServerFactory.getWebServer(servletContext ->
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext))
                        .addMapping("/*"));
        webServer.start();
    }

}
