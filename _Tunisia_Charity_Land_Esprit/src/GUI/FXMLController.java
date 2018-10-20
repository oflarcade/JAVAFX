/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class FXMLController implements Initializable {

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

     
    
    /**
     * Login/Sign-up Button navigation
     * @param event
     * @throws IOException 
     */
    @FXML
    public void navigateConnexion(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("registrationGuiFXML.fxml"));
        cnxBtn.getScene().setRoot(root);
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    
}
