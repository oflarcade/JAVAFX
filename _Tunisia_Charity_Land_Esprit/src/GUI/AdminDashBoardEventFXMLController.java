/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML
    private AnchorPane myPane;
    @FXML
    private Button logouBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private Button blogButton;
    @FXML
    private Button usersBtn;
    @FXML
    private Button ProfileBtn;
    @FXML
    private TableView<?> eventsTable;
    @FXML
    private Button validateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button contactButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    public void navigateToProfile() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
        ProfileBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToPosts() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Gui/AdminDashBoardBlogFXML.fxml"));
        blogButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToUsers() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/AdminDashBoardUserFXML.fxml"));
        eventBtn.getScene().setRoot(root);
    } 
    
    @FXML
    public void navigateToExit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        logouBtn.getScene().setRoot(root);
    }
}
