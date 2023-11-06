package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/**")
                .addPathPatterns("editor.md/**")
                .addPathPatterns("js/**")
                .addPathPatterns("img/**")
                .addPathPatterns("css/**")
                .addPathPatterns("/login.html")
                .addPathPatterns("/reg.html")
                .addPathPatterns("blog_list.html")
                .addPathPatterns("blog_content.html")
                .addPathPatterns("/user/login")
                .addPathPatterns("/user/reg");
    }
}
