package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Hall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Hall implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3043313654341390082L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer HallId;
	private Integer max_size;
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="hall" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	private List<Seat> seats = new ArrayList<Seat>();
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="cimema_Id")
	private Cimema cimema;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private HallStatus status;
	
	public Hall() {}
	public Integer getHallId() {
		return HallId;
	}
	public void setHallId(Integer hallId) {
		HallId = hallId;
	}
	public Integer getMax_size() {
		return max_size;
	}
	public void setMax_size(Integer max_size) {
		this.max_size = max_size;
	}
	
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
    public  Cimema getCimema() {
		return cimema;
	}
	public void setCimema(Cimema cimema) {
		this.cimema = cimema;
	}
	
	public HallStatus getStatus() {
		return status;
	}
	public void setStatus(HallStatus status) {
		this.status = status;
	}
}
