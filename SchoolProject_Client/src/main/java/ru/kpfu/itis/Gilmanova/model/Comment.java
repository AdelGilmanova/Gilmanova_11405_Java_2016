package ru.kpfu.itis.Gilmanova.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 18.05.2016.
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String userName;
    private String content;
    private Time time;
    private Date date;

    public Comment(String userName, String content, Time time, Date date) {
        this.userName = userName;
        this.content = content;
        this.time = time;
        this.date = date;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Имя пользователя: " + userName + "\nКомментарий: " + content +
                "\n---------------------------";
    }
}
