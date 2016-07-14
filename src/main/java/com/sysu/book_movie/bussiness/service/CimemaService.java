package com.sysu.book_movie.bussiness.service;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Cimema;

public interface CimemaService {
	public Cimema getCimemaById(Integer id);
    public List<Cimema> getCimemaByName(String cimemaName);
    public List<Cimema> getCimemasByCity(String city);
    public List<Cimema> getCimemaByRegion(String region);
    public void addCimema(Cimema cimema);
    public void updateCimema(Cimema cimema);
    public void deleteCimema(Integer id);
}
