package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="User")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5292519311579774091L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer UserId;
	private Integer userRole;
	private String userName;
	private String password;
	private String telphone;
	private String email;
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="user" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public User() {}
	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	
}
