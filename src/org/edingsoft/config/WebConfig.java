package org.edingsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan("org.edingsoft")
@EnableWebMvc
public class WebConfig {
	  @Bean
	    public UrlBasedViewResolver setupViewResolver() {
	        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	        resolver.setPrefix("/template/");
	        resolver.setSuffix(".jsp");
	        resolver.setViewClass(JstlView.class);
	        return resolver;
	    }
	  
	  
}
