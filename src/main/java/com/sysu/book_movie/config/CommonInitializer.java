package com.sysu.book_movie.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;

@Order(1)
public class CommonInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		//OpenSessionInViewFilter
        OpenSessionInViewFilter hibernateSessionInViewFilter = new OpenSessionInViewFilter();  
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(  
                "hibernateFilter", hibernateSessionInViewFilter);
        
        filterRegistration.addMappingForUrlPatterns(  
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");
        
	}

}
