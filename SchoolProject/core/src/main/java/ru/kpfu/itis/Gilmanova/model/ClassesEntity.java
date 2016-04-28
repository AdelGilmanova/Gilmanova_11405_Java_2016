package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 25.04.2016.
 */
@Entity
@Table(name = "classes", schema = "public", catalog = "school_project")
public class ClassesEntity {
    private int id;
    private String clazz;
    private TeachersEntity teachersByTeacherId;
    private List<ClassTeacherObjectEntity> class_teacher_object_id;
    private List<StudentsEntity> student_id;

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
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeachersEntity getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(TeachersEntity teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "class_id",
            targetEntity = ClassTeacherObjectEntity.class)
    public List<ClassTeacherObjectEntity> getClass_teacher_object_id() {
        return class_teacher_object_id;
    }

    public void setClass_teacher_object_id(List<ClassTeacherObjectEntity> class_teacher_object_id) {
        this.class_teacher_object_id = class_teacher_object_id;
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "class_id",
            targetEntity = StudentsEntity.class)
    public List<StudentsEntity> getStudent_id() {
        return student_id;
    }

    public void setStudent_id(List<StudentsEntity> student_id) {
        this.student_id = student_id;
    }
}
