package com.brianway.learning.java.spring_boot_test.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by lengbing on 2017/7/5.
 */
@Primary
@Configuration
public class RestfulWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new RestfulRequestMappingHandlerMapping();
    }
}
