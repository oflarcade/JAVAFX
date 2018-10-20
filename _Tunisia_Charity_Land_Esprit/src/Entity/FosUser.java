/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.util.Date;
/**
 *
 * @author oflcad
 */
public class FosUser {
    private int id;
    private String username;
    private String email;
    private String enabled;
    private String salt;
    private String password;
    private Date last_login;
    private int locked;
    private int expired;
    private Date expires_at;
    private String confirmation_token;
    private Date password_requested_at;
    private String roles;
    private int crendentials_expired;
    private Date crendentials_expires_at;

    public FosUser() {
    }

    //this is for the User part
    public FosUser(int id, String username, String email, String enabled, String password, int locked, int expired, Date expires_at, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.locked = locked;
        this.expired = expired;
        this.expires_at = expires_at;
        this.roles = roles;
    }

    public FosUser( String username, String email, String password) {
        
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
        
}
