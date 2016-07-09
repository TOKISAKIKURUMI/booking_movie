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
@Table(name = "Cimera")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cimema implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2879479163753280007L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cimemaId;
	private String cimemaName;
	private String city;
	private String region;
	private String address;
	private String descrption;
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="cimema" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	private List<Hall> halls = new ArrayList<Hall>();
	@OneToMany(mappedBy="cimema", fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<Screening> screenings = new ArrayList<Screening>();


	public Cimema() {};

	public Integer getCimemaId() {
		return cimemaId;
	}

	public void setCimemaId(Integer cimemaId) {
		this.cimemaId = cimemaId;
	}

	public String getCimemaName() {
		return cimemaName;
	}

	public void setCimemaName(String ximemaName) {
		this.cimemaName = ximemaName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	
	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}
	
	public List<Screening> getScreenings() {
		return screenings;
	}

	public void setScreenings(List<Screening> screenings) {
		this.screenings = screenings;
	}
}
