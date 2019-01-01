package com.asamu.plmp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;
	

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login","/user/login", "/logout","/error","/403",
                        "/jquery-3.3.1.min.js","/js/**","/css/**","/images/**","/layui/**","/json/**");
    }
}
