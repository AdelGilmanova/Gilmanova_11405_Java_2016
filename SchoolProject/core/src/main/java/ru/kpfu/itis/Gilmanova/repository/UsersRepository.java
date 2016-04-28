package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.repository.jpa.ClassesRepositoryJPA;

import java.sql.Date;
import java.util.List;

/**
 * Created by Adel on 07.03.2016.
 */
@Repository
public class UsersRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ClassesRepositoryJPA classesRepositoryJPA;

    /*
     * Достает пользовалеля по логину
     */
    public UsersEntity getUser(String login) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        return (UsersEntity) crit.add(Restrictions.eq("username", login)).uniqueResult();
    }

    /*
     * Достает пользовалеля по id
     */
    public UsersEntity getUser(Integer id) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        return (UsersEntity) crit.add(Restrictions.eq("id", id)).uniqueResult();
    }

    /*
     * Добавление нового пользователя-учащийся в бд
     */
    public void addUser(String lastName, String firstName, Integer classId, String login, String hash_pass) {
        UsersEntity user = new UsersEntity(login, hash_pass, true, "ROLE_STUDENT");
        ClassesEntity classesEntity = classesRepositoryJPA.getClassById(classId);
        StudentsEntity studentsEntity = new StudentsEntity(lastName, firstName, classesEntity, user);
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(studentsEntity);
    }

    /*
     * Получение списка всех учащихся из таблицы Users
     */
    @SuppressWarnings("unchecked")
    public List<UsersEntity> getStudents() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        crit.add(Restrictions.eq("role", "ROLE_STUDENT"));
        return crit.list();
    }

    /*
     * Добавление нового пользователя-преподаватель в бд
     */
    public void addUser(String lastName, String firstName, String secondName, Date birthday, String gender,
                        String login, String hash_pass) {
        UsersEntity user = new UsersEntity(login, hash_pass, true, "ROLE_TEACHER");
        String photo = "/resources/images/photo.png";
        TeachersEntity teachersEntity = new TeachersEntity(lastName, firstName, secondName, gender, birthday, photo, user);
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(teachersEntity);
    }
}
