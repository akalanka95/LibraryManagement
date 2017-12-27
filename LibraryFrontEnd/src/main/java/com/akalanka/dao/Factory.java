/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Factory {
    public SessionFactory sessionFactory;
    public Session session;
    
    public Factory(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
