package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Reservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2081133612529301679L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer RId;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="user_Id")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Screening_id")
	private Screening screening;
	
	public Reservation() {}
	public Integer getRId() {
		return RId;
	}
	public void setRId(Integer rId) {
		RId = rId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Screening getScreening() {
		return screening;
	}
	public void setScreening(Screening screening) {
		this.screening = screening;
	}

}
