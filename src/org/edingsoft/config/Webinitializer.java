package org.edingsoft.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Webinitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext  springctx=new AnnotationConfigWebApplicationContext ();
		springctx.register(WebConfig.class);
		springctx.setServletContext(ctx); 
		Dynamic servlet=ctx.addServlet("dispatcher", new DispatcherServlet(springctx) );
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
	
}
