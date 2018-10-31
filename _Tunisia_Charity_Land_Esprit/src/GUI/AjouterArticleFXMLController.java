/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Article;
import Service.ServiceArticle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AjouterArticleFXMLController implements Initializable {

    @FXML
    private JFXTextArea auteur_article;
    @FXML
    private JFXTextArea titre_article;
    @FXML
    private JFXTextArea image_article;
    @FXML
    private JFXTextArea contenu_article;
    @FXML
    private JFXButton boutton_ajout;
    @FXML
    private JFXButton bouton_cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) throws SQLException, IOException {
          Article a = new Article();
        a.setImage_url(image_article.getText());
        a.setTitre(titre_article.getText());
          a.setContenu(contenu_article.getText());
        int ida = Integer.parseInt(auteur_article.getText());

        a.setId_auteur(ida);
        
        ServiceArticle sa = new ServiceArticle();
        sa.add(a);
        Parent root = FXMLLoader.load(getClass().getResource("Gui/GestionArticleFXML.fxml"));
        
        //Scene scene = new Scene(root);
        boutton_ajout.getScene().setRoot(root);
    }
    
}
