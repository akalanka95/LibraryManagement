/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.dao;

import com.akalanka.dto.Member;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;

/**
 *
 * @author Akalanka
 */
public class MemberDao extends Factory {
    
    public boolean add(Member member) {
		try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        session.persist(member);
                        session.getTransaction().commit();
                        System.out.println("sucessssss");
			return true;
		}catch(Exception e) {
                     System.out.println("Failed");
			e.printStackTrace();
			return false;
		}
	}
    
     public ObservableList<Member> list() {
            
                 ObservableList<Member> memberList = FXCollections.observableArrayList();
		 String selectMemberList = " FROM Member"; 
                 session = sessionFactory.openSession();
                 session.beginTransaction();
                 Query query = session.createQuery(selectMemberList);
               
                 List<Member> mList =  query.getResultList();
                for (Member ent : mList) {
            memberList.add(ent);
        }
                 session.getTransaction().commit();
         return memberList;       
        }
}
