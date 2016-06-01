package com.sysu.book_movie.bussiness.daos;

import org.hibernate.Session;

public interface CurrentSession {
    public Session getCurrentSession();
}
