package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "objects", schema = "public", catalog = "school_project")
public class ObjectsEntity {
    private int id;
    private String object;
    private List<TeacherObjectEntity> teacher_object;

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
    @Column(name = "object")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "objectsEntity",
            targetEntity = TeacherObjectEntity.class)
    public List<TeacherObjectEntity> getTeacher_object() {
        return teacher_object;
    }

    public void setTeacher_object(List<TeacherObjectEntity> teacher_object) {
        this.teacher_object = teacher_object;
    }
}
