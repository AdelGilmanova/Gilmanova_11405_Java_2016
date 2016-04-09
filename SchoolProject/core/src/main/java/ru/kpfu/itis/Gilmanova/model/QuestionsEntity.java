package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 08.04.2016.
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

    public QuestionsEntity() {
    }

    public QuestionsEntity(String theme, String questionContent, String email, String questionName,
                           Time questionTime, Date questionDate) {
        this.theme = theme;
        this.questionContent = questionContent;
        this.email = email;
        this.questionName = questionName;
        this.questionTime = questionTime;
        this.questionDate = questionDate;
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

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (questionContent != null ? questionContent.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (questionName != null ? questionName.hashCode() : 0);
        result = 31 * result + (questionTime != null ? questionTime.hashCode() : 0);
        result = 31 * result + (questionDate != null ? questionDate.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsEntity that = (QuestionsEntity) o;

        if (id != that.id) return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        if (questionContent != null ? !questionContent.equals(that.questionContent) : that.questionContent != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (questionName != null ? !questionName.equals(that.questionName) : that.questionName != null) return false;
        if (questionTime != null ? !questionTime.equals(that.questionTime) : that.questionTime != null) return false;
        if (questionDate != null ? !questionDate.equals(that.questionDate) : that.questionDate != null) return false;

        return true;
    }
}
