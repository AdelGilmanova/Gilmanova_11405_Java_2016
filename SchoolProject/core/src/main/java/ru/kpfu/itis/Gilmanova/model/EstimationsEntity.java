package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "estimations", schema = "public", catalog = "school_project")
public class EstimationsEntity {
    private int id;
    private StudentObjectTeacherEntity studentObjectTeacherByInfoId;
    private Integer estimate0;
    private Integer estimate1;
    private Integer estimate2;
    private Integer estimate3;
    private Integer estimate4;
    private Integer estimate5;
    private Integer estimate6;
    private Integer estimate7;
    private Integer estimate8;
    private Integer estimate9;
    private Integer semester;
    private Integer year;
    private Integer finalGrade;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estimate0")
    public Integer getEstimate0() {
        return estimate0;
    }

    public void setEstimate0(Integer estimate0) {
        this.estimate0 = estimate0;
    }

    @Basic
    @Column(name = "estimate1")
    public Integer getEstimate1() {
        return estimate1;
    }

    public void setEstimate1(Integer estimate1) {
        this.estimate1 = estimate1;
    }

    @Basic
    @Column(name = "estimate2")
    public Integer getEstimate2() {
        return estimate2;
    }

    public void setEstimate2(Integer estimate2) {
        this.estimate2 = estimate2;
    }

    @Basic
    @Column(name = "estimate3")
    public Integer getEstimate3() {
        return estimate3;
    }

    public void setEstimate3(Integer estimate3) {
        this.estimate3 = estimate3;
    }

    @Basic
    @Column(name = "estimate4")
    public Integer getEstimate4() {
        return estimate4;
    }

    public void setEstimate4(Integer estimate4) {
        this.estimate4 = estimate4;
    }

    @Basic
    @Column(name = "estimate5")
    public Integer getEstimate5() {
        return estimate5;
    }

    public void setEstimate5(Integer estimate5) {
        this.estimate5 = estimate5;
    }

    @Basic
    @Column(name = "estimate6")
    public Integer getEstimate6() {
        return estimate6;
    }

    public void setEstimate6(Integer estimate6) {
        this.estimate6 = estimate6;
    }

    @Basic
    @Column(name = "estimate7")
    public Integer getEstimate7() {
        return estimate7;
    }

    public void setEstimate7(Integer estimate7) {
        this.estimate7 = estimate7;
    }

    @Basic
    @Column(name = "estimate8")
    public Integer getEstimate8() {
        return estimate8;
    }

    public void setEstimate8(Integer estimate8) {
        this.estimate8 = estimate8;
    }

    @Basic
    @Column(name = "estimate9")
    public Integer getEstimate9() {
        return estimate9;
    }

    public void setEstimate9(Integer estimate9) {
        this.estimate9 = estimate9;
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

    public double avg() {
        int sum = 0;
        int k = 0;
        Integer est[] = {estimate0, estimate1, estimate2, estimate3, estimate4, estimate5, estimate6,
                estimate7, estimate8, estimate9};
        for (int i = 0; i < 10; i++) {
            if (est[i] != null) {
                sum += est[i];
                k++;
            } else break;
        }
        if (k != 0) return (double) sum / k;
        else return 0;
    }

    public String stringAvg() {
        int sum = 0;
        int k = 0;
        Integer est[] = {estimate0, estimate1, estimate2, estimate3, estimate4, estimate5, estimate6,
                estimate7, estimate8, estimate9};
        for (int i = 0; i < 10; i++) {
            if (est[i] != null) {
                sum += est[i];
                k++;
            } else break;
        }
        if (k != 0) return String.format("%.1f", (double) sum / k);
        else return "0";
    }
}
