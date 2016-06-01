package com.sysu.book_movie.bussiness.entity;

public enum MovieType {
     Comedy(0), Campus(1), Action(2), Adventure(3), Thriller(4), Love(5), Science(6), War(7), Porn(8);
     private Integer movietype;
     
     private MovieType(Integer movietype) {
    	 this.movietype = movietype;
     }
     
     public Integer getMovieType() {
    	 return movietype;
     }
}
