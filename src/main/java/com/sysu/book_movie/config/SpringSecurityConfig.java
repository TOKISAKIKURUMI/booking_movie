package com.sysu.book_movie.config;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.sysu.book_movie.util.MyPersistentTokenBasedRememberMeService;
import com.sysu.book_movie.util.MyUserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = Logger
			.getLogger(SpringSecurityConfig.class);
	@Autowired
	private DataSource dataSource;
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/static/**", "/**/*.html");

	}
	
	 @Override  
	 protected void configure(HttpSecurity http) throws Exception {  
	  
	        // 开启默认登录页面  
	        // http.formLogin();  
		   http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
	        // 自定义登录页面  
	        http.csrf().disable().formLogin().defaultSuccessUrl("/index")
	                .loginPage("/login")
	                .failureUrl("/loginfailure")  
	                .loginProcessingUrl("/login.do")  
	                .usernameParameter("username")  
	                .passwordParameter("password").permitAll();  
	        
	  
	        // 自定义注销  
	        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
	                .invalidateHttpSession(true).permitAll();  
	  
	        // session管理  
	        http.sessionManagement().sessionFixation().changeSessionId()  
	                .maximumSessions(1).expiredUrl("/login");  
	  
	        // RemeberMe  
	        http.rememberMe().key("elim").rememberMeCookieName("remember-me").tokenRepository(persistentTokenRepository()).rememberMeServices(rememberServices())
	        .tokenValiditySeconds(1209600);
	        //http.addFilterBefore(usernamePasswordAuthenticationFilter(), BasicAuthenticationFilter.class);
	  
	 }
	 
	 @Override
	 @AliasFor("authenticationManager")
	 protected void configure(AuthenticationManagerBuilder auth)  
	            throws Exception {  
	        //这里要加
	        // 自定义UserDetailsService
		    auth.eraseCredentials(false);
		    //auth.authenticationProvider( rememberMeAuthenticationProvider());
	        auth.userDetailsService(myUserDetailsService());
	        auth.authenticationProvider(rememberMeAuthenticationProvider());
	  
	 }
	 
	 @Bean(name="myAuthenticationManager")
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	 }
	 
	 
	 @Bean  
	 public LoggerListener loggerListener() {  
	        logger.info("org.springframework.security.authentication.event.LoggerListener");  
	        LoggerListener loggerListener = new LoggerListener();  
	  
	        return loggerListener;  
	 }
	 
	 @Bean  
	 public org.springframework.security.access.event.LoggerListener eventLoggerListener() {  
	        logger.info("org.springframework.security.access.event.LoggerListener");  
	        org.springframework.security.access.event.LoggerListener eventLoggerListener = new org.springframework.security.access.event.LoggerListener();  
	  
	        return eventLoggerListener;  
	 }
	 
	 @Bean
	 public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
		 UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
		 usernamePasswordAuthenticationFilter.setRememberMeServices(rememberServices());
		 usernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
		 usernamePasswordAuthenticationFilter.setUsernameParameter("username");
		 usernamePasswordAuthenticationFilter.setPasswordParameter("password");
		 usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/login.do");
		 return usernamePasswordAuthenticationFilter;
	 }
	 @Bean
	 public RememberMeAuthenticationFilter rememberMeFilter() throws Exception {
		 RememberMeAuthenticationFilter reMeAuthenticationFilter = new RememberMeAuthenticationFilter(authenticationManagerBean(), rememberServices());
		 return reMeAuthenticationFilter;
	 }
	 
	 
	 @Bean
     public MyPersistentTokenBasedRememberMeService rememberServices() {
		    MyPersistentTokenBasedRememberMeService persistentTokenBasedRememberMeServices = new MyPersistentTokenBasedRememberMeService("elim", myUserDetailsService(), persistentTokenRepository());
		    persistentTokenBasedRememberMeServices.setParameter("_spring_security_remember_me");
		    persistentTokenBasedRememberMeServices.setCookieName("remember-me");
			return persistentTokenBasedRememberMeServices;
	 }
	 @Bean
	 public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
		 RememberMeAuthenticationProvider _rememberMeAuthenticationProvider = new RememberMeAuthenticationProvider("elim");
		 return _rememberMeAuthenticationProvider;
	 }
	 @Bean
     public PersistentTokenRepository persistentTokenRepository() {
			JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
			db.setDataSource(dataSource);
			//db.setCreateTableOnStartup(true);
			return db;
	 }
	 
	 @Bean
	 public MyUserDetailsService myUserDetailsService() {
		 return new MyUserDetailsService();
	 }
}
