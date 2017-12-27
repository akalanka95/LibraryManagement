/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.controller;

import com.akalanka.dao.BookDao;
import com.akalanka.dto.Book;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Akalanka
 */
public class AddBookController implements Initializable {

    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtPublisher;
    @FXML
    private Button btnaddBook;
    @FXML
    private Button btnCancel;

    
    Book book;
    BookDao bookDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookDao = new BookDao();
        book = new Book();
        System.out.println("initialize new one");
    }    

    @FXML
    private void addBook(ActionEvent event) {
        
        book.setBookId(txtId.getText());
        book.setBookTitle(txtTitle.getText());
        book.setBookPublisher(txtPublisher.getText());
        book.setBookAuthor(txtAuthor.getText());
        book.setIsAvailable(true);
        
        
        
        if(book.getBookAuthor().isEmpty() || book.getBookPublisher().isEmpty() || book.getBookTitle().isEmpty() || book.getBookId().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Enter data in to all fields");
            alert.showAndWait();
            return; 
        }
        if(bookDao.add(book)){
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

    @FXML
    private void Cancel(ActionEvent event) {
        Stage stage =  (Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
    
}
