package com.sysu.book_movie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration  
@EnableWebMvc  
@ComponentScan(basePackages = "com.sysu.book_movie", useDefaultFilters = false, includeFilters = {  
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})  
})  
public class MvcConfig extends WebMvcConfigurationSupport {
	
	 @Autowired
     private ApplicationContext appContext;
	 
	 @Bean
	 public ResourceBundleMessageSource messageSource() {
	        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
	        resourceBundleMessageSource.setBasename("Messages");
	        return resourceBundleMessageSource;
	 }
	 
	 @Bean
	 public SpringResourceTemplateResolver templateResolver(){
	        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setApplicationContext(this.appContext);
	        templateResolver.setPrefix("/WEB-INF/templates/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode("HTML5");
	        // Template cache is true by default. Set to false if you want
	        // templates to be automatically updated when modified.
	        templateResolver.setCacheable(true);
	        return templateResolver;
	 }
	 
	 @Bean
	 public SpringTemplateEngine templateEngine(){
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	 }

	 @Bean
	 public ThymeleafViewResolver viewResolver(){
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        return viewResolver;
	 }
	 
	 @Bean
	 public CookieLocaleResolver cookieLocaleResolver(){  
	        return new CookieLocaleResolver();  
	 }  
	 
	 /* ******************************************************************* */
	 /*  Defines callback methods to customize the Java-based configuration */
	 /*  for Spring MVC enabled via {@code @EnableWebMvc}                   */
	 /* ******************************************************************* */

	 /**
	  *  Dispatcher configuration for serving static resources
	  */
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	 }

}
