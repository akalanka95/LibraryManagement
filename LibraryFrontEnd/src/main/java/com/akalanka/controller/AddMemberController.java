/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.controller;

import com.akalanka.dao.MemberDao;
import com.akalanka.dto.Member;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddMemberController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtMemId;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnAddMember;
    @FXML
    private Button btnCancel;

    Member member;
    MemberDao memberDao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        member = new Member();
        memberDao = new MemberDao();
    }    

    @FXML
    private void Cancel(ActionEvent event) {
          Stage stage =  (Stage)btnCancel.getScene().getWindow();
          stage.close();
    }

    @FXML
    private void addMember(ActionEvent event) {
          member.setEmail(txtEmail.getText());
         member.setMemberId(txtMemId.getText());
         member.setMobile(txtMobile.getText());
         member.setName(txtName.getText());
         member.setIsActive(true);
   
        if(member.getEmail().isEmpty() || member.getMemberId().isEmpty()|| member.getMobile().isEmpty() || member.getName().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Enter data in to all fields");
            alert.showAndWait();
            return; 
        }
        if(memberDao.add(member)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Success");
            alert.showAndWait();
            return; 
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Failed");
            alert.showAndWait();
            return; 
        }
    }
    
}
