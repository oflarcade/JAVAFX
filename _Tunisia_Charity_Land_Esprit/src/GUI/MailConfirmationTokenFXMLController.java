/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Users;
import Service.UserAuthenticationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class MailConfirmationTokenFXMLController implements Initializable {

    @FXML
    private PasswordField confirmationTokenField;
    private String email ;
    @FXML
    private Button homeButton;
    @FXML
    private Button blogButton;
    @FXML
    private Button eventButton;
    @FXML
    private Button associationButton;
    @FXML
    private Button connectionButton;
    @FXML
    private Button storeButton;
    @FXML
    private TextField emailField;
    @FXML
    private Button activateAccount;
    @FXML
    private Text errorMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emailField.setText(email);
        
    }   
    
    public void initData(String email) {
        this.email  = email;
        
    }
    
    /**
     *
     * @param confirmationToken
     */
    @FXML
    public void checkConfirmationToken(ActionEvent event) throws IOException, SQLException{
        UserAuthenticationService service  = new UserAuthenticationService();
        String userConfirmatiomToken = service.getConfirmationToken(email);
        
        if(confirmationTokenField.getText().equals(userConfirmatiomToken)){
            System.out.println("mail is confirmed !");
            System.out.println("redirect the shit to Raed profile");
            
        }else {
            errorMessage.setText("Please check your confirmation token again !");
        }
        
        
        
        
    }

    @FXML
    private void navigateToHome(ActionEvent event) {
    }

    @FXML
    private void navigateToBlog(ActionEvent event) {
    }

    @FXML
    private void navigateToEvents(ActionEvent event) {
    }

    @FXML
    private void navigateToAssociation(ActionEvent event) {
    }

    @FXML
    private void navigateToProfile(ActionEvent event) {
    }

    @FXML
    private void navigateToStore(ActionEvent event) {
    }
}
