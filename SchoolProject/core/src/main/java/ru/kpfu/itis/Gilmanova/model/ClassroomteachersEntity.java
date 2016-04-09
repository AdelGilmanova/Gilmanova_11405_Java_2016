package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "classroomteachers", schema = "public", catalog = "school_project")
public class ClassroomteachersEntity {
    private int id;
    private String clazz;
    private TeachersEntity teachersByTeacherId;

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
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeachersEntity getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(TeachersEntity teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassroomteachersEntity that = (ClassroomteachersEntity) o;

        if (id != that.id) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;

        return true;
    }
}
