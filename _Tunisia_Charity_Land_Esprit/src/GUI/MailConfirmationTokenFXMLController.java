/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class MailConfirmationTokenFXMLController implements Initializable {

    @FXML
    private PasswordField confirmationTokenField;
    private String username ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }   
    
    public void intitData(String username) {
        this.username = username;
    }
    
    /**
     *
     * @param confirmationToken
     */
    public void checkConfirmationToken(String username){
        //Service service = new Service();
        
    }
}
