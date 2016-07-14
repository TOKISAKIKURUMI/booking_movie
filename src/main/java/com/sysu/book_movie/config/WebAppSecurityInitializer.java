package com.sysu.book_movie.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


@Order(2)  
public class WebAppSecurityInitializer  extends AbstractSecurityWebApplicationInitializer   
{  
    //servletContext.addListener("org.springframework.security.web.session.HttpSessionEventPublisher");  
    //session¼àÌýÆ÷  
    @Override  
    protected boolean enableHttpSessionEventPublisher() {  
        return true;  
    }  
}  
