package com.study.config.autoconfig;

import com.study.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MyAutoConfiguration
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }


}
