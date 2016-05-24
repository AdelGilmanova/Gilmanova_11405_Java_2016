package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "school_project")
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String hashPass;
    private String role;
    private Boolean enable;

    public UsersEntity(String username, String hashPass, Boolean enable, String role) {
        this.username = username;
        this.hashPass = hashPass;
        this.role = role;
        this.enable = enable;
    }

    public UsersEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "hash_pass")
    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "enable")
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
