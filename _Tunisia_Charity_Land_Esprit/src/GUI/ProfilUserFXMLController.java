/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Article;
import Entity.Participant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Service.ServiceUser;
//import entite.Profile;
//import service.ProfileService;
import Entity.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Service.ArticleService;
import java.util.logging.Level;
import java.util.logging.Logger;
import Service.ParticipantService;

/**
 * FXML Controller class
 *
 * @author Raed
 */
public class ProfilUserFXMLController implements Initializable {

    @FXML
    private TextField textusernameuser;
    @FXML
    private TextField textemailuser;
    @FXML
    private TextField textnomuser;
    @FXML
    private TextField textprenomuser;
    @FXML
    private Button enregistreruser;        
    //ProfileService profileService = new ProfileService();
//    Profile profil = profileService.getByUserId(ServiceUser.userStatic.getId());
    
    
    //User a = serv.getUserById(ServiceUser.userStatic.getId());
    //User b = new User (555,"pipo","sarko",1,"raed","djdjd","jbhjbd","admin",null,"999","550cc");
    String lienFacebook;
    String telephone;
    String description;
    @FXML
    private AnchorPane toolbar;
    @FXML
    private ImageView buttuser;
    @FXML
    private ImageView buttuser1;
    @FXML
    private ImageView buttuser2;
    @FXML
    private ImageView buttevents;
    @FXML
    private AnchorPane profil;
    @FXML
    private AnchorPane events;
     @FXML
    private TableView<Participant> tableviewuser;
    @FXML
    private TableColumn<Participant, Date> cdate;
    @FXML
    private TableColumn<Participant , Integer> ceventid;
    @FXML
    private TableColumn<Participant , Integer> cuserid;
       @FXML
    private Button supprimerpart;
      @FXML
    private TextField textsupp;
    @FXML
    private TextField textrech;
    @FXML
    private Label warning;
    @FXML
    private ImageView buttblog;
    @FXML
    private AnchorPane blog;
    @FXML
    private TableView<Article> tableviewart;
    @FXML
    private TableColumn<Article, Integer> cid;
    @FXML
    private TableColumn<Article, Integer> cauthorid;
    @FXML
    private TableColumn<Article, Date> cdateart;
    @FXML
    private TableColumn<Article , String> ctitle;
    @FXML
    private TableColumn<Article , String> ccontent;
    @FXML
    private TableColumn<Article , String> cimage;
       @FXML
    private Button supprimerart;
      @FXML
    private TextField textsuppart; 
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // textusernameuser.setText(capitalizeFirstLetter(ServiceUser.userStatic.getUsername()) );
       // textnomuser.setText(capitalizeFirstLetter(ServiceUser.userStatic.getNom()));
       // textprenomuser.setText(capitalizeFirstLetter(ServiceUser.userStatic.getPrenom()));
       // textemailuser.setText(ServiceUser.userStatic.getEmail());
         textusernameuser.setText("bb" );
        textnomuser.setText("aa");
        textprenomuser.setText("sss");
        textemailuser.setText("ddd");
         ParticipantService pa = null;
        try {
            pa = new ParticipantService();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Participant> part = new ArrayList();
        // User b = new User (555,"pipo","sarko",1,"raed","djdjd","jbhjbd","admin",null,"999","550cc");
      //  try {
          //  part = (ArrayList<Participant>) pa.getByUserID(ServiceUser.userStatic.getId());
           part = (ArrayList <Participant>) pa.getByUserID(1);
      // } catch (SQLException ex) {
        //    Logger.getLogger(MyeventsUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     //  }
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewuser.setItems(obs);
          
            cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
            ceventid.setCellValueFactory(new PropertyValueFactory<>("eventid"));
            cuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
         
           
       
        // TODO
    }    

    private void Myeventsuser(ActionEvent event) {
       try{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MyeventsUserFXML.fxml"));
       Parent root = (Parent) fxmlloader.load();
       Stage stage = new Stage();
       stage.setTitle("Mes Evenements");
       stage.setScene(new Scene(root));
       stage.show();
               }catch (Exception e){
                   System.out.println(e);
               }
    }

    private void Mesblogsuser(ActionEvent event) {
           try{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MyarticlesFXML.fxml"));
       Parent root = (Parent) fxmlloader.load();
       Stage stage = new Stage();
       stage.setTitle("Mes Blogs");
       stage.setScene(new Scene(root));
       stage.show();
               }catch (Exception e){
                   System.out.println(e);
               }
    }

    private void Mesarticlesuser(ActionEvent event) {
         try{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MyorderFXML.fxml"));
       Parent root = (Parent) fxmlloader.load();
       Stage stage = new Stage();
       stage.setTitle("Mes Commandes");
       stage.setScene(new Scene(root));
       stage.show();
               }catch (Exception e){
                   System.out.println(e);
               }
    }

    @FXML
    private void Enregistreruser(ActionEvent event){try{
      ServiceUser serv = new ServiceUser();
     //   b.setUsername(textusernameuser.getText());
      //  b.setNom(textnomuser.getText());
       // b.setPrenom(textprenomuser.getText());
       // b.setEmail(textemailuser.getText());
        //serv.modifierUser(b);
        System.out.println("Modifié");
    }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
     public String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    @FXML
    private void handlebutton(MouseEvent event) throws SQLException {
          if (event.getTarget()== buttuser){
            profil.setVisible(true);
            events.setVisible(false);
           blog.setVisible(false);
            
      
        }else if (event.getTarget()== buttevents){
           profil.setVisible(false);
            events.setVisible(true);
            blog.setVisible(false);
        }else if(event.getTarget()== buttblog){
           profil.setVisible(false);
            events.setVisible(false);
            blog.setVisible(true);
             ArticleService as = new ArticleService();
        ArrayList<Article> asl = new ArrayList();
        // User b = new User (555,"pipo","sarko",1,"raed","djdjd","jbhjbd","admin",null,"999","550cc");
      //  try {
          //  part = (ArrayList<Participant>) pa.getByUserID(ServiceUser.userStatic.getId());
           asl = (ArrayList <Article>) as.getByUserID(1);
      // } catch (SQLException ex) {
        //    Logger.getLogger(MyeventsUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     //  }
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableviewart.setItems(obs);
            cid.setCellValueFactory(new PropertyValueFactory<>("id"));
            cauthorid.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            cdateart.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            ctitle.setCellValueFactory(new PropertyValueFactory<>("titre"));
            ccontent.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            cimage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
        }
    }
    @FXML
     private void supprimerPart(ActionEvent event) throws SQLException, IOException{
            ParticipantService or = new ParticipantService();
            int a = Integer.parseInt(textsupp.getText());
     
       boolean b=or.rech(a);
       if (b==true){
           or.suppPart(a);
             try{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("DialogFXML.fxml"));
       Parent root = (Parent) fxmlloader.load();
       Stage stage = new Stage();
       stage.setTitle("Dialog");
       stage.setScene(new Scene(root));
       stage.show();
               }catch (Exception e){
                   System.out.println(e);

               }}
       else 
           warning.setText("ID erroné");
        ParticipantService pa = new ParticipantService();
        ArrayList<Participant> part = new ArrayList();
     //   User c = new User (555,"pipo","sarko",1,"raed","djdjd","jbhjbd","admin",null,"999","550cc");
      //  try {
          //  part = (ArrayList<Participant>) pa.getByUserID(ServiceUser.userStatic.getId());
           part =  (ArrayList<Participant>) pa.getByUserID(1);
      // } catch (SQLException ex) {
        //    Logger.getLogger(MyeventsUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     //  }
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewuser.setItems(obs);
            cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
            ceventid.setCellValueFactory(new PropertyValueFactory<>("eventid"));
            cuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
         
           
       
               
       
    }    
    @FXML
       private void rechercheavancee(KeyEvent event) throws SQLException {
            
        String x=textrech.getText();
        String y="'%"+x+"%'";
        System.out.println(y);
        ParticipantService pa = new ParticipantService();
        ArrayList<Participant> part = new ArrayList();
         //User b = new User (555,"pipo","sarko",1,"raed","djdjd","jbhjbd","admin",null,"999","550cc");
      //  try {
          //  part = (ArrayList<Participant>) pa.getByUserID(ServiceUser.userStatic.getId());
           part = pa.rechercherPart(555);
      // } catch (SQLException ex) {
        //    Logger.getLogger(MyeventsUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     //  }
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewuser.setItems(obs);
            cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
            ceventid.setCellValueFactory(new PropertyValueFactory<>("eventid"));
            cuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
         
         
    }
         @FXML
    private void supprimerArt(ActionEvent event) throws SQLException, IOException{
            ArticleService or = new ArticleService();
            int a = Integer.parseInt(textsuppart.getText());
       or.suppArticle(a);
    }    
    
}
