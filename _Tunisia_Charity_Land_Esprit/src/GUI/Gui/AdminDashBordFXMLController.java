/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Gui;

import Entity.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.prefs.Preferences;
import Entity.Users;
import java.io.FileOutputStream;
/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class AdminDashBordFXMLController implements Initializable {

    @FXML
    private AnchorPane myPane;
    @FXML
    private Button eventBtn;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField role;
    
    private Users selectedUser;
    @FXML
    private Button ProfileBtn;
    @FXML
    private TextField idField;
    @FXML
    private TextField expiresField;
    @FXML
    private TextField enabledField;
    @FXML
    private Button logouBtn;
    @FXML
    private Button blogButton;
    @FXML
    private Button usersBtn;
        
    
    /*
     * This Method gets an Admin to initialize the view 
     */
    public void initData(Users user){
        
        this.selectedUser = user;
        
        String idValue = String.valueOf(selectedUser.getId());
        String expiresValue = String.valueOf(selectedUser.getExpires_at());
        email.setText(selectedUser.getEmail());
        password.setText(selectedUser.getPassword());
        role.setText(selectedUser.getRoles());
        
        idField.setText(idValue);
        expiresField.setText(expiresValue);
        enabledField.setText(String.valueOf(selectedUser.getEnabled()));
        
        System.out.println(user.toString());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
    }    
    
    @FXML
    public void editProfile() throws SQLException, IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashBoardProfileFXML.fxml"));
                
                
                Parent root = (Parent) loader.load();
                AdminDashBoardProfileFXMLController controller = loader.<AdminDashBoardProfileFXMLController>getController();
                controller.initDate(selectedUser);
                
                ProfileBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToUsers() throws SQLException,IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardUserFXML.fxml"));
        usersBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToBlog() throws SQLException,IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardBlogFXML.fxml"));
        blogButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToEvents() throws SQLException,IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardEventFXML.fxml"));
        eventBtn.getScene().setRoot(root);
    }
    @FXML 
    public void logout() throws SQLException,IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegistraionGuiFXML.fxml"));
        logouBtn.getScene().setRoot(root);
    }
}
