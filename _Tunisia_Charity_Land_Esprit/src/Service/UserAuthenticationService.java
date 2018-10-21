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
import java.util.prefs.Preferences;

/**
 *
 * @author oflcad
 */
public class UserAuthenticationService {
    
    private final Connection connection;
    
    PreparedStatement preparedStatement;
    Preferences usPreferences ;
     
    public UserAuthenticationService() throws SQLException {
        connection = DataSource.getInstance().getConnection();
        usPreferences = Preferences.userRoot();
    }
    
    /*
    * using true or false to authenticate user
    */
    public Users authenticateUserWithCrendentials(String username, String password){
            Users user = new Users();
          
            
            String query = "SELECT * from fos_user where roles ='admin'"; 
            try {
            preparedStatement = connection.prepareStatement(query);
            
          
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                user.setUser_id(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoles(rs.getString("roles"));
                System.out.println("console log from auth Service"+user.getId());
                System.out.println(user.toString());
                return user;
            }

        } catch (SQLException e) {
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
        String query = "SELECT * FROM fos_user WHERE id=? roles = 'admin'";
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       return user;
    }
}
