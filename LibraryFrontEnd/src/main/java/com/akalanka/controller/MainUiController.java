
package com.akalanka.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainUiController implements Initializable {

    @FXML
    private Button addMember;
    @FXML
    private Button addBook;
    @FXML
    private Button memberList;
    @FXML
    private Button bookList;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loadAddMember(ActionEvent event) {
        loadWindow("/fxml/AddMember.fxml","Add Member");
    }

    @FXML
    private void loadAddBook(ActionEvent event) {
        loadWindow("/fxml/AddBook.fxml","Add Book");
    }

    @FXML
    private void loadMemberList(ActionEvent event) {
        loadWindow("/fxml/ListMember.fxml","Members List");
    }

    @FXML
    private void loadBookList(ActionEvent event) {
        loadWindow("/fxml/ListBook.fxml","Book List");
    }
    
    void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(MainUiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
