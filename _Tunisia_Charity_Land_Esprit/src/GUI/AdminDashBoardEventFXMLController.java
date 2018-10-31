/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Entity.Users;
import GUI.Gui.AdminDashBordFXMLController;
import Service.AdminDashBoardService;
import Service.ServiceEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class AdminDashBoardEventFXMLController implements Initializable {

    private Users user;
    @FXML
    private AnchorPane myPane;
    private Button logouBtn;
    @FXML
    private Button blogButton;
    private Button ProfileBtn;
    @FXML
    private TableView<Evenement> eventsTable;
    @FXML
    private Button validateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button contactButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button usersButton;
    @FXML
    private Button eventButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button apiControllButton;
    @FXML
    private TableColumn<Evenement, Integer> idColumn;
    @FXML
    private TableColumn<Evenement, String> titleColumn;
    @FXML
    private TableColumn<Evenement, String> byColumn;
    @FXML
    private TableColumn<Evenement, String> descriptionColumn;
    @FXML
    private TableColumn<Evenement, Date> createdAt;
    @FXML
    private TableColumn<Evenement, String> typeColumn;
    @FXML
    private TableColumn<Evenement, Integer> statusColumn;
    @FXML
    private Pane buttonPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            profileButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            usersButton.setStyle("-fx-text-fill: balck;-fx-background-color: transparent;");
            blogButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent;");
            eventButton.setStyle("-fx-text-fill: #F25652;-fx-background-color: transparent;");
            apiControllButton.setStyle("-fx-text-fill: black;-fx-background-color: transparent; ");
            logoutButton.setStyle("-fx-text-fill: white;-fx-background-color: transparent;");
            
            
    }    
    
    @FXML
    public void refreshData(ActionEvent event) throws IOException {
          System.out.println("hello from refresh");
            ArrayList<Evenement> eventsList;
            ServiceEvenement service = new ServiceEvenement();
            eventsList = service.read();
            ObservableList observableList = FXCollections.observableList(eventsList);
            eventsTable.setItems(observableList);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            byColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("enabled"));
            createdAt.setCellValueFactory(new PropertyValueFactory<>("last_login"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            //lockedColumn.setCellFactory(new PropertyValueFactory<>("locked"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("statusColumn"));
            
    }
    
    
    
    @FXML
    public void navigateToProfile() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBordFXML.fxml"));
        Parent root = (Parent) loader.load();
        AdminDashBordFXMLController controller = loader.<AdminDashBordFXMLController>getController() ;
        controller.initData(this.user);
        
        profileButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToPosts() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardBlogFXML.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardBlogFXMLController controller = loader.<AdminDashBoardBlogFXMLController>getController() ;
        controller.initData(this.user);
        blogButton.getScene().setRoot(root);
    }
    
    @FXML
    public void navigateToUsers() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardUserFXML.fxml"));
        Parent root =  (Parent) loader.load();
        AdminDashBoardUserFXMLController controller = loader.<AdminDashBoardUserFXMLController>getController();
        controller.initData(user);
        
        usersButton.getScene().setRoot(root);
    } 
    
    @FXML
    public void navigateToExit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Gui/registrationGuiFXML.fxml"));
        logouBtn.getScene().setRoot(root);
    }
    
    /**
     *
     * @param user
     */
    public void initData(Users user){
        this.user = user;
    }

    

   @FXML
    public void navigateToApiControll(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui/AdminDashBoardApiController.fxml"));
         Parent root = (Parent) loader.load();
        AdminDashBoardApiController controller = loader.<AdminDashBoardApiController>getController() ;
        controller.initData(user);
        
        apiControllButton.getScene().setRoot(root);
    }
}
