package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 26.04.2016.
 */
@Entity
@Table(name = "class_teacher_object", schema = "public", catalog = "school_project")
public class ClassTeacherObjectEntity {
    private int id;
    private ClassesEntity class_id;
    private TeacherObjectEntity teacher_object_id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = ClassesEntity.class)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    public ClassesEntity getClass_id() {
        return class_id;
    }

    public void setClass_id(ClassesEntity class_id) {
        this.class_id = class_id;
    }

    @ManyToOne(targetEntity = TeacherObjectEntity.class)
    @JoinColumn(name = "teacher_object_id", referencedColumnName = "id")
    public TeacherObjectEntity getTeacher_object_id() {
        return teacher_object_id;
    }

    public void setTeacher_object_id(TeacherObjectEntity teacher_object_id) {
        this.teacher_object_id = teacher_object_id;
    }
}
