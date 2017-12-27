package com.akalanka.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.akalanka.dao.MemberDao;
import com.akalanka.dto.Member;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Akalanka
 */
public class ListMemberController implements Initializable {

    @FXML
    private TableColumn<Member, String> colMemberId;
    @FXML
    private TableColumn<Member, String> colName;
    @FXML
    private TableColumn<Member, String> colMobile;
    @FXML
    private TableColumn<Member, String> colEmail;
    @FXML
    private TableView<Member> tableView;

    Member member;
    MemberDao memberDao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        memberDao = new MemberDao();
        
        colMemberId.setCellValueFactory(new PropertyValueFactory<Member, String>("memberId") );
        colName.setCellValueFactory(new PropertyValueFactory<Member, String>("name") );
        colMobile.setCellValueFactory(new PropertyValueFactory<Member, String>("mobile") );
        colEmail.setCellValueFactory(new PropertyValueFactory<Member, String>("email") );
        
        tableView.setItems(memberDao.list());
        
    }    
    
}
