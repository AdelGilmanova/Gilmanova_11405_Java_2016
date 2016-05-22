package ru.kpfu.itis.Gilmanova.model;

import java.io.Serializable;

/**
 * Created by Adel on 07.04.2016.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String hashPass;
    private String role;
    private Boolean enable;

    public User(String username, String hashPass, Boolean enable, String role) {
        this.username = username;
        this.hashPass = hashPass;
        this.role = role;
        this.enable = enable;
    }

    public User() {
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

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
