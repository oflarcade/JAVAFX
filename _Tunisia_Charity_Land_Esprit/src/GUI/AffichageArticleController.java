/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Article;
import Service.ServiceArticle;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private int CurrP = 1;
    int index;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceArticle serv = new ServiceArticle();
            ArrayList<Article> listOfArticle = serv.read();
            initTitle(listOfArticle);
        } catch (SQLException ex) {
            Logger.getLogger(AffichageArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToNext(ActionEvent event) {
        try {
            ServiceArticle serv = new ServiceArticle();
            ArrayList<Article> listOfArticle = serv.read();
             loadNextPage() ;
                } catch (SQLException ex) {
            Logger.getLogger(AffichageArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToPrevious(ActionEvent event) {
    }

    public int fct(int i) {
        if (i != 0) {
            return 1;
        } else {
            return i;
        }
    }

    public void loadTitle1(String t) {
        titre1.setText(t);
    }

    public void loadTitle2(String t) {
        titre2.setText(t);
    }

    public void initTitle(ArrayList<Article> a) {
        if (a.size() > 0) {
            loadTitle1(a.get(0).getTitre());
        }
        if (a.size() > 1) {
            loadTitle2(a.get(1).getTitre());
        }
    }

    public void initTitle() {
        titre1.setText("...");
    }

    public void loadNextPage() {
        ServiceArticle serv;
        try {
            serv = new ServiceArticle();
            ArrayList<Article> listOfArticle = serv.read();
            int nbP = listOfArticle.size() / 2 + fct(listOfArticle.size() % 2);
             
            if(CurrP<nbP){
                index=CurrP*2;
                loadTitle1(listOfArticle.get(index).getTitre());
                index++;
                loadTitle2(listOfArticle.get(index).getTitre());
                CurrP++;
            }
            else if(CurrP<nbP){
                initTitle();
                if (index<listOfArticle.size()){
                    loadTitle1(listOfArticle.get(index).getTitre());
                index++;
                }
                if (index<listOfArticle.size()){
                    loadTitle2(listOfArticle.get(index).getTitre());
                index++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichageArticleController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
