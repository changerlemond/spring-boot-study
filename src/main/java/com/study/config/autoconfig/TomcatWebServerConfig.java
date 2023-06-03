package com.study.config.autoconfig;

import com.study.config.ConditionalMyOnClass;
import com.study.config.EnableMyConfigurationProperties;
import com.study.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatServletWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties) {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();

        tomcatServletWebServerFactory.setContextPath(serverProperties.getContextPath());
        tomcatServletWebServerFactory.setPort(serverProperties.getPort());

        return tomcatServletWebServerFactory;
    }
}
