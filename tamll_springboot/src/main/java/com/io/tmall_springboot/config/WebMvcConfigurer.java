package com.io.tmall_springboot.config;

import com.io.tmall_springboot.interceptor.LoginInterceptor;
import com.io.tmall_springboot.interceptor.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    public LoginInterceptor getLoginIntercepter(){
        return new LoginInterceptor();
    }
    @Bean
    public OtherInterceptor getOtherInterceptor(){
        return new OtherInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webapp/**").addResourceLocations("classpath:/webapp/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registy){
        registy.addInterceptor(getLoginIntercepter()).addPathPatterns("/**");
        registy.addInterceptor(getOtherInterceptor()).addPathPatterns("/**");
    }
}
