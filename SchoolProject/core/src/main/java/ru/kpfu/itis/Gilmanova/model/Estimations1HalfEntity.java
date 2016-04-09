package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "estimations_1half", schema = "public", catalog = "school_project")
public class Estimations1HalfEntity {
    private int id;
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
    private Integer finalGrade;
    private ObjectsEntity objectsByObjectId;
    private StudentsEntity studentsByStudentId;

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
    @Column(name = "final_grade")
    public Integer getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Integer finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (estimate0 != null ? estimate0.hashCode() : 0);
        result = 31 * result + (estimate1 != null ? estimate1.hashCode() : 0);
        result = 31 * result + (estimate2 != null ? estimate2.hashCode() : 0);
        result = 31 * result + (estimate3 != null ? estimate3.hashCode() : 0);
        result = 31 * result + (estimate4 != null ? estimate4.hashCode() : 0);
        result = 31 * result + (estimate5 != null ? estimate5.hashCode() : 0);
        result = 31 * result + (estimate6 != null ? estimate6.hashCode() : 0);
        result = 31 * result + (estimate7 != null ? estimate7.hashCode() : 0);
        result = 31 * result + (estimate8 != null ? estimate8.hashCode() : 0);
        result = 31 * result + (estimate9 != null ? estimate9.hashCode() : 0);
        result = 31 * result + (finalGrade != null ? finalGrade.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id", nullable = false)
    public ObjectsEntity getObjectsByObjectId() {
        return objectsByObjectId;
    }

    public void setObjectsByObjectId(ObjectsEntity objectsByObjectId) {
        this.objectsByObjectId = objectsByObjectId;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estimations1HalfEntity that = (Estimations1HalfEntity) o;

        if (id != that.id) return false;
        if (estimate0 != null ? !estimate0.equals(that.estimate0) : that.estimate0 != null) return false;
        if (estimate1 != null ? !estimate1.equals(that.estimate1) : that.estimate1 != null) return false;
        if (estimate2 != null ? !estimate2.equals(that.estimate2) : that.estimate2 != null) return false;
        if (estimate3 != null ? !estimate3.equals(that.estimate3) : that.estimate3 != null) return false;
        if (estimate4 != null ? !estimate4.equals(that.estimate4) : that.estimate4 != null) return false;
        if (estimate5 != null ? !estimate5.equals(that.estimate5) : that.estimate5 != null) return false;
        if (estimate6 != null ? !estimate6.equals(that.estimate6) : that.estimate6 != null) return false;
        if (estimate7 != null ? !estimate7.equals(that.estimate7) : that.estimate7 != null) return false;
        if (estimate8 != null ? !estimate8.equals(that.estimate8) : that.estimate8 != null) return false;
        if (estimate9 != null ? !estimate9.equals(that.estimate9) : that.estimate9 != null) return false;
        if (finalGrade != null ? !finalGrade.equals(that.finalGrade) : that.finalGrade != null) return false;

        return true;
    }
}
