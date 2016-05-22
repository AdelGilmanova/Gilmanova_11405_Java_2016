package ru.kpfu.itis.Gilmanova.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 28.04.2016.
 */

public class HomeWork implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Time time;
    private Date date;
    private String homeWork;

    public HomeWork() {
    }

    public HomeWork(String homeWork, Time time, Date date) {
        this.homeWork = homeWork;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

}
