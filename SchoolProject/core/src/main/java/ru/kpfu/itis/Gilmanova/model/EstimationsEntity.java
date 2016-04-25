package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 24.04.2016.
 */
@Entity
@Table(name = "estimations", schema = "public", catalog = "school_project")
public class EstimationsEntity {
    private int id;
    private StudentObjectTeacherEntity studentObjectTeacherByInfoId;
    private Integer estimate;
    private Integer semester;
    private Integer year;
    private Integer finalGrade;

    public EstimationsEntity(StudentObjectTeacherEntity studentObjectTeacherByInfoId,
                             Integer estimate, Integer semester, Integer year) {
        this.studentObjectTeacherByInfoId = studentObjectTeacherByInfoId;
        this.estimate = estimate;
        this.semester = semester;
        this.year = year;
    }

    public EstimationsEntity() {
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
    @Column(name = "estimate")
    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    @Basic
    @Column(name = "semester")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "final_grade")
    public Integer getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Integer finalGrade) {
        this.finalGrade = finalGrade;
    }

    @ManyToOne
    @JoinColumn(name = "info_id", referencedColumnName = "id")
    public StudentObjectTeacherEntity getStudentObjectTeacherByInfoId() {
        return studentObjectTeacherByInfoId;
    }

    public void setStudentObjectTeacherByInfoId(StudentObjectTeacherEntity studentObjectTeacherByInfoId) {
        this.studentObjectTeacherByInfoId = studentObjectTeacherByInfoId;
    }
}
