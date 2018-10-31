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
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class AdminDashBoardEventFXMLController implements Initializable {

    private Users user;
    @FXML
    private AnchorPane myPane;
    private Button logouBtn;
    @FXML
    private Button blogButton;
    private Button ProfileBtn;
    @FXML
    private TableView<?> eventsTable;
    @FXML
    private Button validateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button contactButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button usersButton;
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
        // TODO
            profileButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            usersButton.setStyle("-fx-text-fill: balck;-fx-background-color: transparent;");
            blogButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            eventButton.setStyle("-fx-text-fill: #F25652;-fx-background-color: transparent;");
            apiControllButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent; ");
            logoutButton.setStyle("-fx-text-fill: white;-fx-background-color: transparent;");
    }    
    
    
    
    @FXML
    public void navigateToProfile() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
        Parent root = (Parent) loader.load();
        AdminDashBordFXMLController controller = loader.<AdminDashBordFXMLController>getController() ;
        controller.initData(this.user);
        
        profileButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToPosts() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardBlogFXML.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardBlogFXMLController controller = loader.<AdminDashBoardBlogFXMLController>getController() ;
        controller.initData(this.user);
        blogButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToUsers() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardUserFXML.fxml"));
        Parent root =  (Parent) loader.load();
        AdminDashBoardUserFXMLController controller = loader.<AdminDashBoardUserFXMLController>getController();
        controller.initData(user);
        
        usersButton.getScene().setRoot(root);
    } 
    
    @FXML
    public void navigateToExit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        logouBtn.getScene().setRoot(root);
    }
    
    /**
     *
     * @param user
     */
    public void initData(Users user){
        this.user = user;
    }

    

   @FXML
    public void navigateToApiControll(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardApiController.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardApiController controller = loader.<AdminDashBoardApiController>getController() ;
        controller.initData(user);
        
        apiControllButton.getScene().setRoot(root);
    }
}
