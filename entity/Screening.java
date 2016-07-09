package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.omg.CORBA.PRIVATE_MEMBER;

@Entity
@Table(name = "Reservation")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Screening implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer SId;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="movie_Id")
	private Movie movie;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="cimema_Id")
	private Cimema cimema;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="hall_Id")
	private Hall hall;
	@OneToMany(mappedBy="screening" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.DELETE_ORPHAN})
	private List<SeatState> current_seats;
	@OneToMany(mappedBy="screening", fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Reservation> reservations;
	@Column(name="ticket_price")
	private float price;
	@Column(nullable = false)
	private Date time;
	
	public Screening() {}
	
	public Integer getSId() {
		return SId;
	}
	public void setSId(Integer sId) {
		SId = sId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Cimema getCimema() {
		return cimema;
	}
	public void setCimema(Cimema cimema) {
		this.cimema = cimema;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public List<SeatState> getCurrent_seats() {
		return current_seats;
	}
	public void setCurrent_seats(List<SeatState> current_seats) {
		this.current_seats = current_seats;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
    
}
