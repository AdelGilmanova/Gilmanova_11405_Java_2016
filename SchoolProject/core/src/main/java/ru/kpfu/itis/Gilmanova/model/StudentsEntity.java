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
    private UsersEntity usersEntity;

    public StudentsEntity() {
    }

    public StudentsEntity(String lastName, String firstName, ClassesEntity class_id, UsersEntity usersEntity) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.class_id = class_id;
        this.usersEntity = usersEntity;
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

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
