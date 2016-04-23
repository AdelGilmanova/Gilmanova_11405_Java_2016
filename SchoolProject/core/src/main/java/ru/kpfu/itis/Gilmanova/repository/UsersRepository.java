package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Adel on 07.03.2016.
 */
@Repository
public class UsersRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Достает пользовалеля по логину
     */
    public UsersEntity getUser(String login) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UsersEntity.class);
        return (UsersEntity) crit.add(Restrictions.eq("username", login)).uniqueResult();
    }

    /*
     * Добавление нового пользователя в бд
     */
    public Integer addUser(String userName, String hash_pass) throws NoSuchAlgorithmException {
        UsersEntity user = new UsersEntity(userName, hash_pass, true, "ROLE_STUDENT");
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

}
