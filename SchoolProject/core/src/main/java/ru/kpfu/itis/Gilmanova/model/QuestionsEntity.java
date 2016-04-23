package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "questions", schema = "public", catalog = "school_project")
public class QuestionsEntity {
    private int id;
    private String theme;
    private String questionContent;
    private String email;
    private String questionName;
    private Time questionTime;
    private Date questionDate;

    public QuestionsEntity(String theme, String questionContent, String email, String questionName, Time questionTime, Date questionDate) {
        this.theme = theme;
        this.questionDate = questionDate;
        this.questionTime = questionTime;
        this.questionName = questionName;
        this.email = email;
        this.questionContent = questionContent;
    }

    public QuestionsEntity() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "question_content")
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "question_name")
    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    @Basic
    @Column(name = "question_time")
    public Time getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Time questionTime) {
        this.questionTime = questionTime;
    }

    @Basic
    @Column(name = "question_date")
    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

}
