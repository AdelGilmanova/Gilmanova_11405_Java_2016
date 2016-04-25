package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.CommentsEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class CommentsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает список всех комментов
     */
    @SuppressWarnings("unchecked")
    public List<CommentsEntity> getComments() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(CommentsEntity.class);
        return cr.list();
    }

    /*
     * Добавление нового комментария в бд
     */
    @SuppressWarnings("unchecked")
    public void addComment(String name, String text, Time time, Date date) {
        CommentsEntity commentsEntity = new CommentsEntity(name, text, time, date);
        sessionFactory.getCurrentSession().save(commentsEntity);
    }

    /*
     * Удаление комментария по id
     */
    public void deleteComment(Integer commentId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(CommentsEntity.class);
        CommentsEntity comment = (CommentsEntity) crit.add(Restrictions.eq("id", commentId)).uniqueResult();
        sessionFactory.getCurrentSession().delete(comment);
    }
}
