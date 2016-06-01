package com.sysu.book_movie.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  
//����ע���������ʹ��CGLib����  
@EnableTransactionManagement
@PropertySource("classpath:book_movie.properties")
@Import({DataSourceConfig.class}) 
public class DaoConfig {
	 private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	 private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	 private static final String PROPERTY_NAME_HIBERNATE_HBMDDL_AUTO = "hibernate.hbm2ddl.auto";
	 private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	 private static final String PROPERTY_NAME_HINERNATE_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
	 private static final String PROPERTY_NAME_HINERNATE_SECONG_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
	 private static final String PROPERTY_NAME_HINERNATE_USE_STRUCTURED_ENTIRE = "hibernate.cache.use_structured_entries";
	 private static final String PROPERTY_NAME_HINERNATE_GENERATE = "hibernate.generate_statistics";
	 private static final String PROPERTY_NAME_HINERNATE_FACORY_CLASS = "hibernate.cache.region.factory_class";
	 
	 @Resource
	 private Environment env;
	 
	 @Resource(name = "dataSource")
	 private DataSource datasource;
	    
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	        sessionFactoryBean.setDataSource(datasource);
	        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(
	PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
	        sessionFactoryBean.setHibernateProperties(hibProperties());
	        return sessionFactoryBean;
	 }
	 
	 private Properties hibProperties() {
	        Properties properties = new Properties();
	        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	        //��һ�����״���mysql�������ݱ��ǲ�ʹ�ã�֮��ע�͵�����Ȼÿ������hibernate�Ὣ���ݱ�ɾ��
	        //properties.put(PROPERTY_NAME_HIBERNATE_HBMDDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBMDDL_AUTO));
	        properties.put(PROPERTY_NAME_HINERNATE_USE_QUERY_CACHE, env.getRequiredProperty(PROPERTY_NAME_HINERNATE_USE_QUERY_CACHE));
	        properties.put(PROPERTY_NAME_HINERNATE_SECONG_LEVEL_CACHE, env.getRequiredProperty(PROPERTY_NAME_HINERNATE_SECONG_LEVEL_CACHE));
	        properties.put(PROPERTY_NAME_HINERNATE_FACORY_CLASS, env.getRequiredProperty(PROPERTY_NAME_HINERNATE_FACORY_CLASS));
	        properties.put(PROPERTY_NAME_HINERNATE_USE_STRUCTURED_ENTIRE, env.getRequiredProperty(PROPERTY_NAME_HINERNATE_USE_STRUCTURED_ENTIRE));
	        properties.put(PROPERTY_NAME_HINERNATE_GENERATE, env.getRequiredProperty(PROPERTY_NAME_HINERNATE_GENERATE));
	        return properties;  
	 }
	 
	 @Bean
	 public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	 }

}
