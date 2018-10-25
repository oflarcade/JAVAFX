/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.UserAuthenticationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class SignupFXMLController implements Initializable {

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
    private Button blogBtn;
    @FXML
    private Button homrBtn;
    @FXML
    private TextField personalUsername;
    @FXML
    private TextField personalEmail;
    @FXML
    private TextField personalPassword;
    @FXML
    private TextField personalSecondPassword;
    @FXML
    private Button personalSignup;
    @FXML
    private RadioButton personalCheckBox;
    @FXML
    private TextField assoName;
    @FXML
    private TextField assoEmail;
    @FXML
    private PasswordField assPassword;
    @FXML
    private PasswordField assSecondPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goHome() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Gui/FXML.fxml"));
        homrBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void signInUserWithUsernameAndEmailAndPassword(ActionEvent event) {
        //Signing User with username email and password
        String username = personalUsername.getText();
        String email = personalEmail.getText();
        String password = personalPassword.getText();
        String secondPassword = personalPassword.getText();
        boolean isCreated = false;
        try {
            UserAuthenticationService service =  new UserAuthenticationService();
            //TODO Consume the service of signing for normal user;
            isCreated = service.signInUserWithUsernameAndEmailAndPassword(username, email, password, secondPassword);
            System.out.println("TODO Consume the service of signing for normal user");
            System.out.println("this is what happened !"+isCreated);
        } catch (SQLException ex) {
            Logger.getLogger(SignupFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML
    public void signInAssociationWithNameAndEmailAndPassword(ActionEvent event){
        //Signing association with name email and password
        String name = assoName.getText();
        String email = assoEmail.getText();
        String password = assPassword.getText();
        String secondPassword = assSecondPassword.getText();
        boolean isCreated = false;
        try {
            UserAuthenticationService service = new UserAuthenticationService();
            //TODO Consume the service of signing for association
            isCreated = service.signInAssociationWithNameAndEmailAndPassword(name, email, password, secondPassword);
            System.out.println("TODO Consume the service of signing for association");
            System.out.println("this is what happened !"+isCreated);
        } catch (Exception e) {
        }
    }
    
}
