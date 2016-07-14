package com.sysu.book_movie.bussiness.entity;

public enum SeatStatus {
     OWNEDBYPEOPLE("selled"), IDLE("idle");
     private String seat_status;
     
     private SeatStatus(String s) {
    	 this.seat_status = s;
     }
     
     public String getStatus() {
    	 return seat_status;
     }
}
