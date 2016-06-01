package com.sysu.book_movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority; 
import org.springframework.stereotype.Component;

import com.sysu.book_movie.bussiness.entity.User;
import com.sysu.book_movie.bussiness.service.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private UserService userService;
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails userDetails = null;
		try {
			List<User> users = userService.getUserByName(userName);
			//logger.debug(users.size());
			userDetails = new org.springframework.security.core.userdetails.User(
					users.get(0).getUserName(), users.get(0).getPassword().toLowerCase(),
					true, true, true, true, getAuthorities(users.get(0).getUserRole()));
			
		}catch (Exception e) {  
            logger.error("用户信息错误！");  
            throw new UsernameNotFoundException("异常处理：检索用户信息未通过！");  
        }  
           
		return userDetails;
	}
	
	 public Collection<GrantedAuthority> getAuthorities(Integer role) {  
	        System.out.println("取得的权限是  :" + role);  
	        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();  
	  
	        // 所有的用户默认拥有ROLE_USER权限  
	        if (role == 0) {  
	            System.out.println("普通用户");  
	            logger.debug("取得普通用户权限-->");  
	            authList.add(new SimpleGrantedAuthority("ROLE_USERS"));  
	        }  
	        // 如果参数role为1.则拥有ROLE_ADMIN权限  
	        if (role == 1) {  
	            logger.debug("取得ADMIN用户权限-->");  
	            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  
	        }  
	        System.out.println(authList.size()+"  权限列表长度");  
	        return authList;  
	    }  

}
