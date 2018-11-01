/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Article;
import Service.CreatePdf;
import Service.ServiceArticle;
import static Utils.DataSource.getInstance;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import static javax.swing.text.html.HTML.Tag.OL;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class GestionArticleFXMLController implements Initializable {

    @FXML
    private AnchorPane ga_rootpane;
    @FXML
    private TableView<Article> ga_tv;
    @FXML
    private TableColumn<Article, Integer> tv_id;
    @FXML
    private TableColumn<Article, Integer> tv_id_auteur;
    @FXML
    private TableColumn<Article, Date> tv_date;
    @FXML
    private TableColumn<Article, String> tv_titre;
    @FXML
    private TableColumn<Article, String> tv_contenu;
    @FXML
    private TableColumn<Article, String> tv_image;
    @FXML
    private Button addArticleBT;
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
    @FXML
    private Button pdfBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            
            ArrayList<Article> list;
            ServiceArticle SA = new ServiceArticle();
            list = SA.read();
            ObservableList OL = FXCollections.observableArrayList(list);
            ga_tv.setItems(OL);
            tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            tv_id_auteur.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            tv_date.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            tv_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            tv_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            tv_image.setCellValueFactory(new PropertyValueFactory<>("image_url"));
            
           tv_titre.setCellFactory(TextFieldTableCell.forTableColumn());
           tv_contenu.setCellFactory(TextFieldTableCell.forTableColumn());
           tv_image.setCellFactory(TextFieldTableCell.forTableColumn());
           
        } catch (SQLException ex) {
            Logger.getLogger(GestionArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    public void deleteById(ActionEvent event) throws SQLException {
        Article article_selectionne = ga_tv.getSelectionModel().getSelectedItem();
   int id_article = article_selectionne.getId();
  
   ServiceArticle sa = new ServiceArticle();
   sa.deleteById(article_selectionne);
    ArrayList<Article> list = new ArrayList();
            ServiceArticle SA = new ServiceArticle();
            list.remove(article_selectionne);
            list = SA.read();
            ObservableList OL = FXCollections.observableArrayList(list);
          ga_tv.setItems(OL);
            tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            tv_id_auteur.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            tv_date.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            tv_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            tv_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            tv_image.setCellValueFactory(new PropertyValueFactory<>("image_url"));
        }
     @FXML
    public void modifierTitre(TableColumn.CellEditEvent<Article, String> event) {
          Article  articleSelectionne = ga_tv.getSelectionModel().getSelectedItem();
        articleSelectionne.setTitre(event.getNewValue());
        try {
            ServiceArticle serv =new ServiceArticle();
            serv.updateTitre(articleSelectionne, articleSelectionne.getTitre());
        } catch (SQLException ex) {
            Logger.getLogger(GestionArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    public void modifierContenu(TableColumn.CellEditEvent<Article, String> event) {
        Article  articleSelectionne = ga_tv.getSelectionModel().getSelectedItem();
        articleSelectionne.setContenu(event.getNewValue());
        try {
            ServiceArticle serv =new ServiceArticle();
            serv.updateContenu(articleSelectionne, articleSelectionne.getContenu());
        } catch (SQLException ex) {
            Logger.getLogger(GestionArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    public void modifierImage(TableColumn.CellEditEvent<Article, String> event) {
        Article  articleSelectionne = ga_tv.getSelectionModel().getSelectedItem();
        articleSelectionne.setImage_url(event.getNewValue());
        try {
            ServiceArticle serv =new ServiceArticle();
            serv.updateImage(articleSelectionne, articleSelectionne.getImage_url());
        } catch (SQLException ex) {
            Logger.getLogger(GestionArticleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(ActionEvent event) {
    }

    @FXML
    private void navigateToBlog(ActionEvent event) {
    }

    @FXML
    private void navigateToEvents(ActionEvent event) {
    }

    @FXML
    private void navigateToAssociation(ActionEvent event) {
    }

    @FXML
    private void navigateToProfile(ActionEvent event) {
    }

    @FXML
    private void navigateToStore(ActionEvent event) {
    }

   
   

    @FXML
    private void convertToPdf(ActionEvent event) throws FileNotFoundException {
        try {
            CreatePdf.convertToPdf();
        } catch (SQLException | DocumentException ex) {
            Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
   
    

        
   

