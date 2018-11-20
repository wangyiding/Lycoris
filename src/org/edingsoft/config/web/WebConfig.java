package org.edingsoft.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("org.edingsoft")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
	  @Bean
	    public UrlBasedViewResolver setupViewResolver() {
	        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	        resolver.setPrefix("/template/");
	        resolver.setSuffix(".jsp");
//	        resolver.setSuffix(".html");
//	        resolver.setCache(false);
	        resolver.setViewClass(JstlView.class);
	        return resolver;
	    }
	  
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	  
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	    }
	  
}
