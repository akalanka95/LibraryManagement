/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libraryassistance.addBook.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import libraryassistance2.DatabaseHandler.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author Akalanka
 */
public class AddBookController implements Initializable {

    @FXML
    private JFXTextField txtTitle;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtAuthor;
    @FXML
    private JFXTextField txtPublisher;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;

    DatabaseHandler databaseHandler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       databaseHandler = new DatabaseHandler();
    }    

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
