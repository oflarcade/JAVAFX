/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Gui;

import Entity.Users;
import Service.UserAuthenticationService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.prefs.Preferences;
/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class AdminDashBoardProfileFXMLController implements Initializable {

    @FXML
    private AnchorPane myPane;
    @FXML
    private Button mapBtn;
    @FXML
    private Button cnxBtn;
    @FXML
    private Button assoBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField role;
    private Users user;
    @FXML
    private Button ProfileButton;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        System.out.println(user.toString());
    }   
    
    public void initDate(Users user){
        this.user = user ;
    }
    
 
    
    
}
