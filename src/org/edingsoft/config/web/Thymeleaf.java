package org.edingsoft.config.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//@Configuration
//@ComponentScan("org.edingsoft")
//@EnableWebMvc
public class Thymeleaf {
	@Autowired
	ServletContext ctx;
	@Bean
	public ServletContextTemplateResolver setupViewResolver() {
		 ServletContextTemplateResolver resolver=new ServletContextTemplateResolver(ctx);
		 resolver.setPrefix("/template/");
		 resolver.setSuffix(".html");
		 resolver.setTemplateMode("HTML5");
		 resolver.setCacheable(false);
		 resolver.setCharacterEncoding("UTF-8");
		 return resolver;
	}
	
	
	@Bean SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine eng=new SpringTemplateEngine();
		eng.setTemplateResolver(setupViewResolver());
		return eng;
	}
	
	@Bean 
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver tvr=new ThymeleafViewResolver();
		tvr.setTemplateEngine(getTemplateEngine());
		tvr.setCharacterEncoding("utf-8");
		return tvr;
	}
}
