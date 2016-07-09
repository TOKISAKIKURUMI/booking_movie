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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Movie")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9138290507264951398L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer movieId;
	@NotNull
	private String movieName;
	private String descrition;
	private String directior;
	private String actor;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	private MovieType type;
	@OneToMany(mappedBy="movie" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Screening> Screening = new ArrayList<Screening>();
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="movie" ,fetch=FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE, CascadeType.DELETE_ORPHAN})
	private List<Comment> comments = new ArrayList<Comment>();

	public Movie() {}

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getDirectior() {
		return directior;
	}
	public void setDirectior(String directior) {
		this.directior = directior;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public MovieType getType() {
		return type;
	}
	public void setType(MovieType type) {
		this.type = type;
	}
	public List<Screening> getScreening() {
		return Screening;
	}

	public void setScreening(List<Screening> screening) {
		Screening = screening;
	}
}
