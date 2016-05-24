package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "comments", schema = "public", catalog = "school_project")
public class CommentsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private String content;
    private Time time;
    private Date date;

    public CommentsEntity(String userName, String content, Time time, Date date) {
        this.userName = userName;
        this.content = content;
        this.time = time;
        this.date = date;
    }

    public CommentsEntity() {
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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
