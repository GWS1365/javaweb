package io.hz.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置
 *
 * 将访问路径 /statics/** 的映射到 classpath:/statics/
 *
 *WebMvcConfigurer是一个拦截器
 *@Configuration注解将该类交给spring管理
 *@Configuration用于定义配置类，可替换xml配置文件，
 *被注解的类内部包含有一个或多个被@Bean注解的方法，
 *这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 *并用于构建bean定义，初始化Spring容器
 * @author Mark sunlightcs@gmail.com
 * @since 3.0.0 2018-01-25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
    }

    /**
     * 拦截器：配置需要和不需要 拦截的路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/statics/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/captcha.jpg")
                .excludePathPatterns("/sys/login")
                .excludePathPatterns("/Wx_index.html")
                .excludePathPatterns("/Wx_Login")
                .excludePathPatterns("/ggg");
//                .excludePathPatterns("/modules/pro/**");
    }
}
