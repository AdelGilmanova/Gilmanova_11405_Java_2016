package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

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
        crit.add(Restrictions.eq("username", login));
        return (UsersEntity) crit.uniqueResult();
    }
}
