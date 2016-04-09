package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "school_project")
public class UsersEntity {
    private int id;
    private String username;
    private String hashPass;
    private String role;
    private Boolean enable;

    public UsersEntity(String username, String hashPass, Boolean enable, String role) {
        this.username = username;
        this.enable = enable;
        this.role = role;
        this.hashPass = hashPass;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (hashPass != null ? hashPass.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (hashPass != null ? !hashPass.equals(that.hashPass) : that.hashPass != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;

        return true;
    }
}
