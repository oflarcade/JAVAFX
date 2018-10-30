/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Users;
import Service.UserAuthenticationService;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class FXMLController implements Initializable {

    @FXML
    private Button cnxBtn;
    @FXML
    private Button assoBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private Button blogBtn;
    @FXML
    private Button homrBtn;
    public Users loggedInUser;
    UserAuthenticationService service;
    @FXML
    private AnchorPane myPane;

    public FXMLController() {
        try {
            this.service = new UserAuthenticationService();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    /**
     * Login/Sign-up Button navigation
     * @param event
     * @throws IOException 
     */
    @FXML
    public void navigateConnexion(ActionEvent event) throws IOException, Exception{
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        
        cnxBtn.getScene().setRoot(root);
        
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnxBtn.setText("Profile"); 
    }   
    
    @FXML
    public void navigateBlog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BlogGuiFXML.fxml"));
        blogBtn.getScene().setRoot(root);
    }
    
    
    // This is how you pass a user object from one class to another  === Same concept of persistancy
    public void initData(Users user) {
        this.loggedInUser = user;
    }
    
    
}
