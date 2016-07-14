package com.sysu.book_movie.config;


import org.jboss.logging.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig {
	private static final Logger logger = Logger.getLogger(CachingConfig.class);
	
	@Bean  
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {  
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();  
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(  
                "/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;  
    }
	
	@Bean  
    public CacheManager cacheManager() {  
        logger.info("EhCacheCacheManager");  
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();  
        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());  
        return cacheManager;  
    }  
}
