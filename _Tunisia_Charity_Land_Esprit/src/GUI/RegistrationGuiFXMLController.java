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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goHome() throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
               loginBtn.getScene().setRoot(root);
    }
}
