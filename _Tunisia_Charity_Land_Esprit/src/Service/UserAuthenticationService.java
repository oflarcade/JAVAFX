/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Users;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.internet.InternetAddress;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author oflcad
 */
public class UserAuthenticationService {
    
    private final Connection connection;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    PreparedStatement preparedStatement;
    public Users user;
    private boolean isUsernameValid =false;
    private boolean isEmailValid = false;
    private boolean isPasswordValid = false;
    
    private String userValidateError;
    private String emailFieldError;
    private String passwordFieldError;
    public UserAuthenticationService() throws SQLException {
        connection = DataSource.getInstance().getConnection();
    }
    
    /*
    * return user object to authenticate user
    */
    public Users authenticateUserWithCrendentials(String username, String password){
            Users user = new Users();
          
            
            String query = "SELECT * from fos_user WHERE username = ? AND password = ?;"; 
            try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setEnabled(rs.getInt("enabled"));
                
                user.setPassword(rs.getString("password"));
                user.setLast_login(rs.getDate("last_login"));
                user.setLocked(rs.getInt("locked"));
                user.setExpired(rs.getInt("expired"));
                user.setExpires_at(rs.getDate("expires_at"));
                user.setConfirmation_token(rs.getString("confirmation_token"));
                user.setRoles(rs.getString("roles"));
                user.setAdresse(rs.getString("adresse"));
                user.setLocked(rs.getInt("locked"));
                user.setLast_login(rs.getDate("last_login"));
                System.out.println("console log from auth Service : "+user.getId());
                System.out.println(user.toString());
                return user;
            }

        } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Error! we can't communicate with the database ");
        }
        
        return user;
    }
    
    
    public void signInUserWithCredentials(Users user){
        String query = "INSERT INTO users (user_id ,username, email, password,adresse,phone_nbr,image_url) VALUES (?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,122);
            preparedStatement.setString(2, "sqddsq");
            preparedStatement.setString(3, "dsqdsq");
            preparedStatement.setString(4,"213");
            preparedStatement.setString(5, "cogite");
            preparedStatement.setInt(6, 0312321);
            preparedStatement.setString(7, "/dkjsqfdjhqsgkjh");
            
            boolean result = preparedStatement.execute();
                if(result){
                    System.out.println("new user created");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Users getAdminInfo(int id){
        String query = "SELECT * FROM fos_user WHERE id=? and roles='admin'";
        Users user = new Users();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                if(id == user.getId()){
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setRoles(rs.getString("roles"));
                    user.setExpires_at(rs.getDate("expires_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       return user;
    }
    
    
    
   
    
    /*
    *  service for signin a association with name email and password
    */
    public boolean signInAssociationWithNameAndEmailAndPassword(String name, String email, String password, String secondPassword){
          String query = "INSERT INTO fos_user (username,email,enabled,password,locked,expired,confirmation_token,roles,adresse) VALUES (?,?,?,?,?,?,?,?,?)";
        boolean isCreated = false;
        try {//inserting 11 field into database
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, "lvdbqhfbdshqjk");
            preparedStatement.setString(7, "association");
            preparedStatement.setString(8, "");
            isCreated = true;
        } catch (SQLException e) {
            System.out.println("user didn't get created");
            e.printStackTrace();
        }
        return isCreated;
    
    } 
    
    
    /*
    * this method is used to validate the username field from SignupConroller 
    */
    public boolean validateUserName(String name){
        if(name.equals("")){
            System.out.println("name is empty");
            isUsernameValid = false;   
        } else {
            System.out.println("this is the name passed name is valid : "+ name);
            isUsernameValid = true;
        }
        
        return isUsernameValid && checkDatabaseUsernames(name);
    }
    
    
    /*
    * REGEX (regular expression) Email Validation
    */
    public static boolean validateEmail(String email){
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        System.out.println("email is : "+pat.matcher(email).matches());
        return pat.matcher(email).matches();
    }
    
    
    /*
    * Password check service
    */
    public boolean checkPassword(String password, String secondPassword){
        
        if(password.length()>8 && secondPassword.length()>8){
                if(password.equals(secondPassword)){
                    System.out.println("passwords are identical");
                    return isPasswordValid = true;
            }
        }
        return isPasswordValid;
    }
    
    

    
     
     /*
     * Personal user input validation
     */
    public boolean validateUserInputFields(String username, String email, String password, String secondPassword){
        
        return (validateUserName(email) && validateEmail(email) && checkPassword(password, secondPassword));
    }
   
    
    /*
    * Insert new user into database
    */
    public boolean insertNewUserIntoDatabase(String username, String email, String password, String secondPassword){
        boolean isInserted = false;
        String confirmation_token = generateString();
        if(validateUserInputFields(username, email, password, secondPassword)){
            String query = "INSERT INTO fos_user (id,username,email,password,enabled,confirmation_token,roles) VALUES (?,?,?,?,?,?,?)";
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, 11123123);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                preparedStatement.setInt(5, 0);
                preparedStatement.setString(6, confirmation_token);
                preparedStatement.setString(7, "user");
                preparedStatement.executeUpdate();
                System.out.println("please check database new user is created");
                isInserted= true;
                        } catch (SQLException ex) {
                Logger.getLogger(UserAuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isInserted;
    }
    
    
    /*
    * Database check for username existance
    */
    public boolean checkDatabaseUsernames(String username){
        String query = "SELECT * FROM fos_user WHERE username ='"+username+"' ";
        boolean doesExist = false;
        int count = 0;
        try {
            Statement ste = connection.createStatement();
            ResultSet result = ste.executeQuery(query);
            while(result.next()){
                count ++;
                System.out.println("we have found someone !");
            }
            if(count>0){
                System.out.println("this is check database : "+ !doesExist);
                return !doesExist;
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("this is the result from database: "+ count );
        return doesExist;
    }
    
    
    /*
     * This method generate random String used for confirmation Token
    */
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

   
    
    public String getConfirmationToken(String username){
        String confirmation_token = "";
        
        String query = "SELECT confirmation_token FROM fos_user WHERE username = '"+username+"'";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                confirmation_token= result.getString("confirmation_token");
                return confirmation_token;
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
            return "errorFetchingCode";
        }
        
        return "errorFetchingCode";
    }
    
}
