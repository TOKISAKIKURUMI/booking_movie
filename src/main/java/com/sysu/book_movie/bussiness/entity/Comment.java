package com.sysu.book_movie.bussiness.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name = "Comment")
public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886096601999191771L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commentId;
	private String uerName;
	private float score;
	private String content;
	@ManyToOne(fetch=FetchType.EAGER)//解决1+N,级联用ALL
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name="movie_Id")
	private Movie movie;
	
	public Comment() {}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getUerName() {
		return uerName;
	}
	public void setUerName(String uerName) {
		this.uerName = uerName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
