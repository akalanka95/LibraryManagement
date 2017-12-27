/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.dao;

import com.akalanka.dto.Book;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;

public class BookDao extends Factory {
    //private SessionFactory sessionFactory;
   // private Session session;
         public ObservableList<Book> data ;
    
        public BookDao(){
           // sessionFactory = new Configuration().configure().buildSessionFactory();
            
        }
    
	public boolean add(Book book) {
		try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        session.persist(book);
                        session.getTransaction().commit();
                        System.out.println("sucessssss");
			return true;
		}catch(Exception e) {
                     System.out.println("Failed");
			e.printStackTrace();
			return false;
		}
	}
        
        public ObservableList<Book> list() {
            
           /*ObservableList<Book> bookList = FXCollections.observableArrayList();
           session = sessionFactory.openSession();
           session.beginTransaction();
           List<Book> eList = session.
                createCriteria(Book.class).list();
           for (Book ent : eList) {
            bookList.add(ent);
        }
        return bookList;*/
           ObservableList<Book> bookList = FXCollections.observableArrayList();
		String selectProductsList = " FROM Book"; 
                 session = sessionFactory.openSession();
                 session.beginTransaction();
		Query query = session.createQuery(selectProductsList);
               
		List<Book> bList =  query.getResultList();
                for (Book ent : bList) {
            bookList.add(ent);
        }
                 session.getTransaction().commit();
         return bookList;       
        }
}
