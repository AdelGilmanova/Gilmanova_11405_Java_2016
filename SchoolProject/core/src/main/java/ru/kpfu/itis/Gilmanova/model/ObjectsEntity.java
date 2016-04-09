package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "objects", schema = "public", catalog = "school_project")
public class ObjectsEntity {
    private int id;
    private String object;
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
    @Column(name = "object")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (object != null ? object.hashCode() : 0);
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

        ObjectsEntity that = (ObjectsEntity) o;

        if (id != that.id) return false;
        if (object != null ? !object.equals(that.object) : that.object != null) return false;

        return true;
    }
}
