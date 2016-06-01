package com.sysu.book_movie.bussiness.entity;

public enum HallStatus {
     FULL("full"), IDLE("idle");
     private String hall_statu;
     
     private HallStatus(String s) {
    	 this.hall_statu = s;
     }
     
     public String getStatus() {
    	 return hall_statu;
     }
}
