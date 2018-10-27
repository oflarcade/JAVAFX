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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


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
                System.out.println("console log from auth Service : "+user.getId());
                System.out.println(user.toString());
                return user;
            }

        } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("no we can't communicate with the database ");
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
    *  service for signin a user with username email and password
    */
    public boolean signInUserWithUsernameAndEmailAndPassword(String username, String email,String password,String secondPassword){
        String query = "INSERT INTO fos_user (username,email,enabled,password,locked,expired,confirmation_token,roles,adresse) VALUES (?,?,?,?,?,?,?,?,?)";
        boolean isCreadted = false;
        try {//inserting 11 field into database
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, "lvdbqhfbdshqjk");
            preparedStatement.setString(7, "user");
            preparedStatement.setString(8, "");
            return !isCreadted;
        } catch (Exception e) {
            System.out.println("user didn't get created");
            e.printStackTrace();
        }
        return isCreadted;
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
    
    
    public boolean validateUserFields(String username, String email, String password, String secondPassword ){
        boolean isValide = false;
        if((!username.equals("") || !(username == null)) && (checkDatabaseUsernames(username)) && (email.contains("@")) && (password.equals(secondPassword))){
            return !isValide;
        }
        return isValide;
    }
    
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
                return !doesExist;
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doesExist;
    }
    
    
    public boolean verifyAssociationSignedIn(String name, String password) {
        boolean isVerifed = false;
        
        String query ="SELECT username FROM fos_user WHERE username = '"+name+"' " ; 
        
        return isVerifed;
    }
    
}
