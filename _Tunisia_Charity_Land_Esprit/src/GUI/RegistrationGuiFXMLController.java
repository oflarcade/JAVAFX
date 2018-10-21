/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Users;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import Service.UserAuthenticationService;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import GUI.Gui.AdminDashBordFXMLController;
/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class RegistrationGuiFXMLController implements Initializable {

    
    @FXML
    private Button loginBtn;
    @FXML
    private Button SignUpBtn;
    private Users user;
    private boolean  isSignedIn = false;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField login_username;
    @FXML
    private TextField login_pass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goHome() throws IOException, SQLException {
               
               
               String usrname = login_username.getText();
               String pass = login_pass.getText();
               
               
               
                UserAuthenticationService service = new UserAuthenticationService();
                //isLoggedIn = service.authenticateUserWithCrendentials(usrname,pass);
                
                if(true){
                    Parent root = FXMLLoader.load(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
                    loginBtn.getScene().setRoot(root);
                    System.out.println("User is authenticated");
                } else {
                    System.out.println("Usert is not found !!!");
                }
    }
    
    @FXML
    public void goSignUp() throws IOException, SQLException {
            String username = this.username.getText();
            String email = this.email.getText();
            String password  = this.password.getText();
            
               Users user = new Users(2,username , email, password, "", 0, "Admin", "./vdqsjvqdjshgfvqdjs.jpg");
               UserAuthenticationService service  =  new UserAuthenticationService();
               System.out.println("hello from navigation to sign up");
               service.signInUserWithCredentials(user);
               System.err.println("it should be a message just before of user created");
               Parent root = FXMLLoader.load(getClass().getResource("Gui/SignupFXML.fxml"));
               SignUpBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void navigate() throws IOException,SQLException {
            
                
                
                
                String usrname = login_username.getText();
                String pass = login_pass.getText();
            
                UserAuthenticationService service = new UserAuthenticationService();
                user = service.authenticateUserWithCrendentials(usrname,pass);
                System.out.println("from profile ");
                System.out.println(user.toString());
                Parent root = FXMLLoader.load(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
                
                
                
                
                 loginBtn.getScene().setRoot(root);
                
                 
                  
    }
    
    
}
