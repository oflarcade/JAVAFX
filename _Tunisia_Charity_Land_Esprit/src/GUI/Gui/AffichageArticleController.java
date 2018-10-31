/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AffichageArticleController implements Initializable {

    @FXML
    private Label titre1;
    @FXML
    private HBox titre;
    @FXML
    private Label titre2;
    @FXML
    private Button next;
    @FXML
    private Button previous;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToNext(ActionEvent event) {
    }

    @FXML
    private void goToPrevious(ActionEvent event) {
    }
    
}
