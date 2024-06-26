package com.lp.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("user-login");
        registry.addViewController("/user").setViewName("user-profile");
        registry.addViewController("/").setViewName("redirect:/course/get");
    }

}
