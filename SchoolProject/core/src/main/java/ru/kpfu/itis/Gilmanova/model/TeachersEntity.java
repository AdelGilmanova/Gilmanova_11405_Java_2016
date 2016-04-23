package ru.kpfu.itis.Gilmanova.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Adel on 07.04.2016.
 */
@Entity
@Table(name = "teachers", schema = "public", catalog = "school_project")
public class TeachersEntity {
    private int id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String gender;
    private Date birthday;
    private String photo;
    private List<TeacherObjectEntity> teacher_object;

    @Id
    @Column(name = "id")
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

    @Basic
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "teachersByTeacherId",
            targetEntity = TeacherObjectEntity.class)
    public List<TeacherObjectEntity> getTeacher_object() {
        return teacher_object;
    }

    public void setTeacher_object(List<TeacherObjectEntity> teacher_object) {
        this.teacher_object = teacher_object;
    }
}
