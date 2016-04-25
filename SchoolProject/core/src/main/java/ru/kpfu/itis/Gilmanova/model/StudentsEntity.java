package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "students", schema = "public", catalog = "school_project")
public class StudentsEntity {
    private int id;
    private String lastName;
    private String firstName;
    private ClassesEntity class_id;
    private List<StudentObjectTeacherEntity> student_object_teacher;
    private UsersEntity usersEntity;

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
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    public ClassesEntity getClass_id() {
        return class_id;
    }

    public void setClass_id(ClassesEntity class_id) {
        this.class_id = class_id;
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "studentsByStudentId",
            targetEntity = StudentObjectTeacherEntity.class)
    public List<StudentObjectTeacherEntity> getStudent_object_teacher() {
        return student_object_teacher;
    }

    public void setStudent_object_teacher(List<StudentObjectTeacherEntity> student_object_teacher) {
        this.student_object_teacher = student_object_teacher;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
