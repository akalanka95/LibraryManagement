/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akalanka.controller;

import com.akalanka.dao.BookDao;
import com.akalanka.dto.Book;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * FXML Controller class
 *
 * @author Akalanka
 */
public class ListBookController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableColumn<Book, String> colId;
    @FXML
    private TableColumn<Book, String> colTitle;
    @FXML
    private TableColumn<Book, String> colAuthor;
    @FXML
    private TableColumn<Book, String> colPublisher;
    @FXML
    private TableColumn<Book, Boolean> colAvailability;
    @FXML
    private TableView<Book> tableView;

    

    Book book;
    BookDao bookDao;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookDao = new BookDao();
        
        colId.setCellValueFactory(new PropertyValueFactory<Book, String>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("bookTitle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("bookAuthor"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<Book, String>("bookPublisher"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("isAvailable"));
        
        
        tableView.setItems(bookDao.list());
    }    

    
}
