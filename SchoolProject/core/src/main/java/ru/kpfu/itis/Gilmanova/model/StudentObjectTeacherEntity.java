package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "student_object_teacher", schema = "public", catalog = "school_project")
public class StudentObjectTeacherEntity {
    private int id;
    private StudentsEntity studentsByStudentId;
    private TeacherObjectEntity teacherObjectByTeacherObjectId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentObjectTeacherEntity that = (StudentObjectTeacherEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_object_id", referencedColumnName = "id")
    public TeacherObjectEntity getTeacherObjectByTeacherObjectId() {
        return teacherObjectByTeacherObjectId;
    }

    public void setTeacherObjectByTeacherObjectId(TeacherObjectEntity teacherObjectByTeacherObjectId) {
        this.teacherObjectByTeacherObjectId = teacherObjectByTeacherObjectId;
    }
}
