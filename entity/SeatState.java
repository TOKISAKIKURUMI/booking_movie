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

@Entity
@Table(name="seatstate")
public class SeatState implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4050631975253337323L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer StateId;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@JoinColumn(name="screening_Id")
	private Screening screening;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "sstatus")
    private SeatStatus sstatus;
	@OneToOne
	@JoinColumn(name="Seat_Id", referencedColumnName="seatId", unique=true)
	private Seat seat;
	public Integer getStateId() {
		return StateId;
	}
	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	public Screening getScreening() {
		return screening;
	}
	public void setScreening(Screening screening) {
		this.screening = screening;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public SeatStatus getSstatus() {
		return sstatus;
	}
	public void setSstatus(SeatStatus sstatus) {
		this.sstatus = sstatus;
	}
}
