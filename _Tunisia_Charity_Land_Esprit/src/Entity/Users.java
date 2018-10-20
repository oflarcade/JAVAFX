/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author oflcad
 */
public class Users extends FosUser {

    private int user_id;
    private String username;
    private String email;
    private String password;
    private String adresse;
    private int phone_nbr;
    private String image_url;

    public Users(int user_id, String username, String email, String password, String adresse, int phone_nbr, String roles, String image_url) {
        super(user_id, username, email, password, adresse, phone_nbr, roles, image_url);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPhone_nbr() {
        return phone_nbr;
    }

    public void setPhone_nbr(int phone_nbr) {
        this.phone_nbr = phone_nbr;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    
    
   
    
}
