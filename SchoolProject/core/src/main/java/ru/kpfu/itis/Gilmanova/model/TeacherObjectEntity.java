package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "teacher_object", schema = "public", catalog = "school_project")
public class TeacherObjectEntity {
    private int id;
    private TeachersEntity teachersByTeacherId;
    private ObjectsEntity objectsEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    public ObjectsEntity getObjectsEntity() {
        return objectsEntity;
    }

    public void setObjectsEntity(ObjectsEntity objectsEntity) {
        this.objectsEntity = objectsEntity;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public TeachersEntity getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(TeachersEntity teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

}
