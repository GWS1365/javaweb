package io.hz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Freemarker配置
 *
 * 模板路径：classpath:/templates
 * 模板后缀：suffix: .html
 * 
 * 可以使用Freemarker语法，与jsp/html比较
 * 相当于 
 *  <bean class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">  
        <property name="templateLoaderPath" value="WEB-INF/ftl/" />  
        <property name="defaultEncoding" value="UTF-8" />  
     </bean>  
 * @author Mark sunlightcs@gmail.com
 * @since 3.0.0 2017-09-28
 */
@Configuration
public class FreemarkerConfig {

	/**
	 * freeMarker配置，
	 *  classpath:/templates  找模板
     *
     *   在templates里可以使用freeMarker的语法
	 * @return
	 */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates");


        Properties settings = new Properties();
        settings.setProperty("default_encoding", "utf-8");
        settings.setProperty("number_format", "0.##");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

}
