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
import javafx.event.ActionEvent;
/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class RegistrationGuiFXMLController implements Initializable {

    
    @FXML
    private Button loginBtn;
    private Button SignUpBtn;
    private Users user;
    private boolean  isSignedIn = false;
    private TextField username;
    private TextField email;
    private TextField password;
    @FXML
    private TextField login_username;
    @FXML
    private TextField login_pass;
    @FXML
    private Button signupBtn;
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
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    public void goSignUp(ActionEvent event) throws IOException, SQLException {
        
            Parent root = FXMLLoader.load(getClass().getResource("Gui/SignupFXML.fxml"));
            signupBtn.getScene().setRoot(root);
    }
    
    
    //this function is called when a user presses the login button
    @FXML
    public void loginUser(ActionEvent event) throws IOException,SQLException {
            
                    //Getting data from GUI 
                String username = login_username.getText();
                String pass = login_pass.getText();
                
                UserAuthenticationService service = new UserAuthenticationService();
                user = service.authenticateUserWithCrendentials(username,pass);
                String roles = user.getRoles();
                
                System.out.println(username);
                System.out.println(pass);
                System.out.println(roles);
                // case treatment for each type of users
                switch(roles){
                    case "admin":{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
                            Parent root =  (Parent) loader.load();
                            AdminDashBordFXMLController controller = loader.<AdminDashBordFXMLController>getController();
                            System.out.println("This is for ADMIN !!!");
                            controller.initData(user);
                            loginBtn.getScene().setRoot(root);
                        break;
                    }
                    case "user" :{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/FXML.fxml")); // this is home
                            Parent root =  (Parent) loader.load();
                            FXMLController controller = loader.<FXMLController>getController();
                            System.out.println("This is for NORMAL USER !!!");
                            controller.initData(user);
                            loginBtn.getScene().setRoot(root);
                        break;
                    }
                    case "association":{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/FXML.fxml"));
                            Parent root =  (Parent) loader.load();
                            FXMLController controller = loader.<FXMLController>getController();
                            System.out.println("This is for ASSOCIATION USER !!!");
                            controller.initData(user);
                            loginBtn.getScene().setRoot(root);
                        break;
                    }
                }
                
                
                
                 
                  
    }

    @FXML
    private void navigateToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/FXML.fxml"));
        homeButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToBlog(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Gui/BlogGuiFXML.fxml"));
          blogButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToEvents(ActionEvent event)  throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Gui/EventsGuiFXML.fxml"));
        eventButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToAssociation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/AssociationGuiFXML.fxml"));
        associationButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToProfile(ActionEvent event)  throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Gui/RegistrationGuiFXML.fxml"));
         connectionButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToStore(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/StoreGuiFXML.fxml"));
        storeButton.getScene().setRoot(root);
    }
    
    
}
