/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Users;
import GUI.Gui.AdminDashBordFXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class AdminDashBoardApiController implements Initializable {

    private Users user;
    
    @FXML
    private Button profileButton;
    @FXML
    private Button usersButton;
    @FXML
    private Button blogButton;
    @FXML
    private Button eventButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button apiControllButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         profileButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            usersButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            blogButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            eventButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            apiControllButton.setStyle("-fx-text-fill: #F25652;-fx-background-color: transparent; ");
            logoutButton.setStyle("-fx-text-fill: white;-fx-background-color: transparent;");
        // TODO
    }    
    
    
    @FXML
    public void navigateToProfile(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
        Parent root = (Parent) loader.load();
        AdminDashBordFXMLController controller = loader.<AdminDashBordFXMLController>getController() ;
        controller.initData(this.user);
        
        profileButton.getScene().setRoot(root);
    }
    @FXML
    public void navigateToUsers(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardUserFXML.fxml"));
        Parent root =  (Parent) loader.load();
        AdminDashBoardUserFXMLController controller = loader.<AdminDashBoardUserFXMLController>getController();
        controller.initData(user);
        
        usersButton.getScene().setRoot(root);
    }
    
   
    
    @FXML
    public void navigateToEvent(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardEventFXML.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardEventFXMLController controller = loader.<AdminDashBoardEventFXMLController>getController() ;
        controller.initData(this.user);
        
        
        eventButton.getScene().setRoot(root);
    }
    
 
   
    public void navigateToLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        logoutButton.getScene().setRoot(root);
    }
    
    public void initData(Users user){
        this.user = user;
    }

    @FXML
    private void navigateToPosts(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardBlogFXML.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardBlogFXMLController controller = loader.<AdminDashBoardBlogFXMLController>getController();
        controller.initData(this.user);
        blogButton.getScene().setRoot(root);
    }

    @FXML
    private void navigateToExit(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        logoutButton.getScene().setRoot(root);
    }

   

    
}
