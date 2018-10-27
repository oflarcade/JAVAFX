/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.UserAuthenticationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author oflcad
 */
public class SignupFXMLController implements Initializable {

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
    private Button blogBtn;
    @FXML
    private Button homrBtn;
    @FXML
    private TextField personalUsername;
    @FXML
    private TextField personalEmail;
    @FXML
    private TextField personalPassword;
    @FXML
    private TextField personalSecondPassword;
    @FXML
    private Button personalSignup;
    @FXML
    private TextField assoName;
    @FXML
    private TextField assoEmail;
    @FXML
    private PasswordField assPassword;
    @FXML
    private PasswordField assSecondPassword;
    @FXML
    private CheckBox checkBoxUser;
    @FXML
    private Text errorField;
    @FXML
    private Button associationSignup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goHome() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Gui/FXML.fxml"));
        homrBtn.getScene().setRoot(root);
    }
    
    @FXML
    public void signInUserWithUsernameAndEmailAndPassword(ActionEvent event) throws SQLException, IOException {
        
        
        UserAuthenticationService service = new UserAuthenticationService();
        String username = personalUsername.getText();
        String email = personalEmail.getText();
        String password = personalPassword.getText();
        String secondPassword = personalPassword.getText();
        boolean isCreated = false;
        
        if(checkBoxUser.isSelected() && service.validateUserFields(username, email, password, secondPassword) ){
                isCreated = service.signInUserWithUsernameAndEmailAndPassword(username, email, password, secondPassword);
                System.out.println("Check database !"+isCreated);
                
                errorField.setAccessibleHelp("");
        } else { // this means that the user has a problem with the fields
            errorField.setText("You made an error please check your info or checkbox is not selected!");
            System.out.println(service.validateUserFields(username, email, password, secondPassword));
        }

        //Signing User with username email and password
        
        
        //TODO Consume the service of signing for normal user;
        
        
    }
    
    
    @FXML
    public void signInAssociationWithNameAndEmailAndPassword(ActionEvent event) throws SQLException,IOException{
        //Signing association with name email and password
        Parent root  = FXMLLoader.load(getClass().getResource("Gui/FXML.fxml"));
        String name = assoName.getText();
        String email = assoEmail.getText();
        String password = assPassword.getText();
        String secondPassword = assSecondPassword.getText();
        boolean isCreated = false;
        boolean isVerfied = false;
        try {
            UserAuthenticationService service = new UserAuthenticationService();
            //TODO Consume the service of signing for association
            isCreated = service.signInAssociationWithNameAndEmailAndPassword(name, email, password, secondPassword);
            isVerfied = service.verifyAssociationSignedIn(name,password);
            if(isVerfied) {
                System.out.println("TODO Consume the service of signing for association");
            System.out.println("this is what happened !"+isCreated);
            associationSignup.getScene().setRoot(root);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
