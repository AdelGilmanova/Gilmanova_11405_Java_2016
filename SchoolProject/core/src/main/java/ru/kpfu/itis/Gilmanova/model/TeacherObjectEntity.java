package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "teacher_object", schema = "public", catalog = "school_project")
public class TeacherObjectEntity {
    private int id;
    private TeachersEntity teachersByTeacherId;
    private ObjectsEntity objectsEntity;
    private List<ClassTeacherObjectEntity> class_teacher_object_id;

    public TeacherObjectEntity() {
    }

    public TeacherObjectEntity(TeachersEntity teachersByTeacherId, ObjectsEntity objectsEntity) {
        this.teachersByTeacherId = teachersByTeacherId;
        this.objectsEntity = objectsEntity;
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

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "teacher_object_id",
            targetEntity = ClassTeacherObjectEntity.class)
    public List<ClassTeacherObjectEntity> getClass_teacher_object_id() {
        return class_teacher_object_id;
    }

    public void setClass_teacher_object_id(List<ClassTeacherObjectEntity> class_teacher_object_id) {
        this.class_teacher_object_id = class_teacher_object_id;
    }

}
