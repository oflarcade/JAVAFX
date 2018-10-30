/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import Entity.Users;
import Utils.DataSource;
/**
 *
 * @author Raed
 */
public class ServiceUser {
   private Connection con;
    public static Users userStatic = null;
  
   private Statement ste;

    public ServiceUser() throws SQLException {
        this.con = DataSource.getInstance().getConnection();
      try {
          ste=con.createStatement();
      } catch (SQLException ex) {
          System.out.println(ex);
      }
    }
   
   
    
  /*  public void ajouterUser(Users u) throws SQLException
    {
        String requete="INSERT INTO `fos_user` ( `id`, `username` ,`email`,`password`,`roles`) VALUES ( '"+u.getId()+"', '"+u.getUsername()+"', '"+u.getEmail()+"', '"+u.getPassword()+"', '"+u.getRoles()+"');";
       ste.executeUpdate(requete);
    }*/
    public void supprimerUser(int x) throws SQLException
    {
        String requete="DELETE FROM `fos_user` WHERE `id`="+x+";";
        ste.executeUpdate(requete);
    }
    /*public void modifierUser (Users u) throws SQLException
    {
        String requete="UPDATE `fos_user` SET `username`='"+u.getUsername()+"' , `email`='"+u.getEmail()+"' , `password`='"+u.getPassword()+"' , `roles`='"+u.getRoles()+"' WHERE `fos_user`.`id`='"+u.getId()+"';";
        ste.executeUpdate(requete);
    }*/
     public Users getUserById(Integer i) {
        String req = "select * from fos_user where id=?";
        Users u = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = new Users(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"),resultSet.getDate("last_login"),resultSet.getInt("locked"),resultSet.getInt("expired"),resultSet.getDate("expires_at"),resultSet.getString("confirmation_token"), resultSet.getString("roles"),resultSet.getString("adresse"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }

}
