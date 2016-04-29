package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 28.04.2016.
 */
@Entity
@Table(name = "home_work", schema = "public", catalog = "school_project")
public class HomeWorkEntity {
    private int id;
    private Time time;
    private Date date;
    private String homeWork;
    private ClassTeacherObjectEntity classTeacherObjectById;

    public HomeWorkEntity() {
    }

    public HomeWorkEntity(String homeWork, ClassTeacherObjectEntity classTeacherObjectById,Time time, Date date ) {
        this.homeWork = homeWork;
        this.classTeacherObjectById = classTeacherObjectById;
        this.time = time;
        this.date = date;
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

    @Basic
    @Column(name = "home_work")
    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    @ManyToOne
    @JoinColumn(name = "class_teacher_object_id", referencedColumnName = "id")
    public ClassTeacherObjectEntity getClassTeacherObjectById() {
        return classTeacherObjectById;
    }

    public void setClassTeacherObjectById(ClassTeacherObjectEntity classTeacherObjectById) {
        this.classTeacherObjectById = classTeacherObjectById;
    }
}
