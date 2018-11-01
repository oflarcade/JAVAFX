/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Article;
import Entity.Order;
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
import service.OrderService;
import service.ParticipantService;

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
    private TextField textprenomuser;
    @FXML
    private Button enregistreruser;        
  
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
    @FXML
    private TextField textpassuser;
    @FXML
    private TextField textadresseuserr;
    private TextField textmod;
    private TextField rechart;
    @FXML
    private ImageView buttorder;
    @FXML
    private AnchorPane order;
    @FXML
    private TextField textmodorder;
    private TextField textsupporder;
    @FXML
    private Button buttsupporder;
    @FXML
    private Button modorder;
    @FXML
    private TextField textrechorder;
    @FXML
    private TableView<Order> tableorder;
    @FXML
    private TableColumn<Order, Integer> cprodi;
    @FXML
    private TableColumn<Order, Integer> cquantite;
    @FXML
    private TableColumn<Order, Integer> cprix;
    @FXML
    private TableColumn<Order, Integer> cproductowner;
    @FXML
    private TableColumn<Order, Integer> cuseridorder;
    private Label laberr;
    private Users user ;
    private String email;
    private ServiceUser service;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*          FXMLLoader fxmlLoader = new FXMLLoader();
try {
    fxmlLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml").openStream());
    RegistrationGuiFXMLController controller = fxmlLoader.getController();
    // Or use this to find your label
    TextField mytextfield = (TextField) fxmlLoader.getNamespace().get("login_username");
     TextField mytextfield1 = (TextField) fxmlLoader.getNamespace().get("login_pass");
     String a = mytextfield.getText();
     String b = mytextfield1.getText();
} catch (IOException e) {
    e.printStackTrace();
}*/
         textusernameuser.setText("bb" );
        textpassuser.setText("aa");
        textadresseuserr.setText("sss");
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
    
    public void initData(String email){
        this.email = email;
        user = service.getUserByEmail(email);
    }
    
    @FXML
    public void Myeventsuser(ActionEvent event) {
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

    @FXML
    public void Mesblogsuser(ActionEvent event) {
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

    @FXML
    public void Mesarticlesuser(ActionEvent event) {
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
        System.out.println("ModifiÈ");
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
           order.setVisible(false);
            
      
        }else if (event.getTarget()== buttevents){
           profil.setVisible(false);
            events.setVisible(true);
            blog.setVisible(false);
            order.setVisible(false);
        }else if(event.getTarget()== buttblog){
           profil.setVisible(false);
            events.setVisible(false);
            blog.setVisible(true);
            order.setVisible(false);
             ArticleService as = new ArticleService();
        ArrayList<Article> asl = new ArrayList();
           asl = (ArrayList <Article>) as.getByUserID(12);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableviewart.setItems(obs);
            cid.setCellValueFactory(new PropertyValueFactory<>("id"));
            cauthorid.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            cdateart.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            ctitle.setCellValueFactory(new PropertyValueFactory<>("titre"));
            ccontent.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            cimage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
        }
        else if (event.getTarget() ==buttorder){
             profil.setVisible(false);
            events.setVisible(false);
            blog.setVisible(false);
            order.setVisible(true);
             OrderService as = new OrderService();
        ArrayList<Order> asl = new ArrayList();
           asl = (ArrayList <Order>) as.getByUserID(1);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableorder.setItems(obs);
            cprodi.setCellValueFactory(new PropertyValueFactory<>("productid"));
            cuseridorder.setCellValueFactory(new PropertyValueFactory<>("userid"));
            cquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            cproductowner.setCellValueFactory(new PropertyValueFactory<>("productowner"));
            
        }
    }
    
     @FXML
    public void supprimerPart(ActionEvent event) throws SQLException, IOException{
            ParticipantService or = new ParticipantService();
            int a = Integer.parseInt(textsupp.getText());
     
       boolean b=or.rech(a,1);
       if (b==true){
           or.suppPart(a,1);
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
           warning.setText("ID erronÈ");
        ParticipantService pa = new ParticipantService();
        ArrayList<Participant> part = new ArrayList();
           part =  (ArrayList<Participant>) pa.getByUserID(1);
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewuser.setItems(obs);
            cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
            ceventid.setCellValueFactory(new PropertyValueFactory<>("eventid"));
            cuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
         
           
       
               
       
    }    
    @FXML
       public void rechercheavancee(KeyEvent event) throws SQLException {
            
        String x=textrech.getText();
       // String y="'%"+x+"%'";
        int a = Integer.parseInt(x);
        //System.out.println(y);
        ParticipantService pa = new ParticipantService();
        ArrayList<Participant> part = new ArrayList();
        part =  (ArrayList<Participant>) pa.getByUserID(1);
           part = pa.rechercherPart(a,1);
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewuser.setItems(obs);
            cdate.setCellValueFactory(new PropertyValueFactory<>("date"));
            ceventid.setCellValueFactory(new PropertyValueFactory<>("eventid"));
            cuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
         
         
    }
         @FXML
    public void supprimerArt(ActionEvent event) throws SQLException, IOException{
            ArticleService or = new ArticleService();
            int a = Integer.parseInt(textsuppart.getText());
       or.suppArticle(12,a);
        ArticleService as = new ArticleService();
        ArrayList<Article> asl = new ArrayList();
           asl = (ArrayList <Article>) as.getByUserID(12);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableviewart.setItems(obs);
            cid.setCellValueFactory(new PropertyValueFactory<>("id"));
            cauthorid.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            cdateart.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            ctitle.setCellValueFactory(new PropertyValueFactory<>("titre"));
            ccontent.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            cimage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
    }    
    @FXML
    public void modtitre(ActionEvent event) throws SQLException, IOException {
        ArticleService or = new ArticleService ();
        String b = textmod.getText();
        int a = Integer.parseInt(textsuppart.getText());
        or.modArticle(b, a);
         ArticleService as = new ArticleService();
        ArrayList<Article> asl = new ArrayList();
           asl = (ArrayList <Article>) as.getByUserID(12);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableviewart.setItems(obs);
            cid.setCellValueFactory(new PropertyValueFactory<>("id"));
            cauthorid.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            cdateart.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            ctitle.setCellValueFactory(new PropertyValueFactory<>("titre"));
            ccontent.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            cimage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
        
    }

    private void rechercheart(KeyEvent event) throws SQLException {
          String x=rechart.getText();
        String y="'%"+x+"%'";
        //System.out.println(y);
        ArticleService as = new ArticleService();
        ArrayList<Article> part = new ArrayList();
        part =  (ArrayList<Article>) as.getByUserID(12);
           part = as.rechercherArt(y,12);
         ObservableList obs = FXCollections.observableArrayList(part);
            tableviewart.setItems(obs);
            cid.setCellValueFactory(new PropertyValueFactory<>("id"));
            cauthorid.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
            cdateart.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
            ctitle.setCellValueFactory(new PropertyValueFactory<>("titre"));
            ccontent.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            cimage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
    }

    @FXML
    private void supporder(ActionEvent event) throws SQLException {
         OrderService or = new OrderService();
            int a = Integer.parseInt(textsupporder.getText());
       or.suppOrder(a,1);
        OrderService as = new OrderService();
        ArrayList<Order> asl = new ArrayList();
           asl = (ArrayList <Order>) as.getByUserID(1);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableorder.setItems(obs);
            cprodi.setCellValueFactory(new PropertyValueFactory<>("productid"));
            cuseridorder.setCellValueFactory(new PropertyValueFactory<>("userid"));
            cquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            cproductowner.setCellValueFactory(new PropertyValueFactory<>("productowner"));
           
    }

    @FXML
    private void modifierorder(ActionEvent event) throws SQLException {
         OrderService or = new OrderService ();
        int b = Integer.parseInt (textmodorder.getText());
        int a = Integer.parseInt(textsupporder.getText());
        or.modOrder(b, a,1);
         OrderService as = new OrderService();
        ArrayList<Order> asl = new ArrayList();
           asl = (ArrayList <Order>) as.getByUserID(1);
         ObservableList obs = FXCollections.observableArrayList(asl);
            tableorder.setItems(obs);
            cprodi.setCellValueFactory(new PropertyValueFactory<>("productid"));
            cuseridorder.setCellValueFactory(new PropertyValueFactory<>("userid"));
            cquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            cproductowner.setCellValueFactory(new PropertyValueFactory<>("productowner"));
        
    }

    @FXML
    private void rechercheorder(KeyEvent event) throws SQLException ,IOException {
     String x=textrechorder.getText();
     
     if (x !=""){
     int a = Integer.parseInt(x);
      
        OrderService as = new OrderService();
        ArrayList<Order> part = new ArrayList();
        part =  (ArrayList<Order>) as.getByUserID(1);
           part = as.rechercherOrder(1,a);   
       
        
         ObservableList obs = FXCollections.observableArrayList(part);
            tableorder.setItems(obs);
            cprodi.setCellValueFactory(new PropertyValueFactory<>("productid"));
            cuseridorder.setCellValueFactory(new PropertyValueFactory<>("userid"));
            cquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            cproductowner.setCellValueFactory(new PropertyValueFactory<>("productowner"));
     }else if (x == ""){
         laberr.setText("Inserer Prod ID !!");
     }
    }
      @FXML
    void messanger(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Gui/PublicRoom.fxml"));
                
                
               
                
                 buttuser1.getScene().setRoot(root);
    }
}
