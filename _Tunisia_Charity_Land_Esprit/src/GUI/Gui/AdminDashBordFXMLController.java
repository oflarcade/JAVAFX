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
    private Button mapBtn;
    @FXML
    private Button cnxBtn;
    @FXML
    private Button assoBtn;
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
        
    
    /*
     * This Method gets an Admin to initialize the view 
     */
    public void initData(Users user){
        
        this.selectedUser = user;
        email.setText(selectedUser.getEmail());
        password.setText(selectedUser.getPassword());
        role.setText(selectedUser.getRoles());
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
                FXMLLoader loader = FXMLLoader.load(getClass().getResource("Gui/AdminDashBoardProfileFXML.fxml"));
                
                Parent root = (Parent) loader.load();
                AdminDashBoardProfileFXMLController controller = new AdminDashBoardProfileFXMLController();
                controller.initDate(selectedUser);
                
                ProfileBtn.getScene().setRoot(root);
                
                
                
                
                
                
    }
}
