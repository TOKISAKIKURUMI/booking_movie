package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Seat")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Seat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6586370007726774081L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer seatId;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sstatus")
    private SeatStatus sstatus;
	@NotNull
	private Integer seat_row;
	@NotNull
	private Integer seat_col;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="hall_Id")
	private Hall hall;
	@OneToOne(mappedBy="seat", optional=true)
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.DELETE, CascadeType.DELETE_ORPHAN})
	private SeatState seatState;
	
	public Seat() {}
	
	public void setSeatState(SeatState seatState) {
		this.seatState = seatState;
	}
	public void setSstatus(SeatStatus sstatus) {
		this.sstatus = sstatus;
	}

	public Integer getSeat_row() {
		return seat_row;
	}

	public void setSeat_row(Integer seat_row) {
		this.seat_row = seat_row;
	}

	public Integer getSeat_col() {
		return seat_col;
	}

	public void setSeat_col(Integer seat_col) {
		this.seat_col = seat_col;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	
	public Hall getHall() {
		return hall;
	}
	
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
	public SeatStatus getSstatus() {
		return sstatus;
	}

	public SeatState getSeatState() {
		return seatState;
	}
	
}
