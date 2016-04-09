package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

/**
 * Created by Adel on 07.04.2016.
 */
@Repository
public class QuestionsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Добавление вопроса в бд
     */
    @SuppressWarnings("unchecked")
    public void addQuestions(String theme, String text, String email, String name) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE)+ ":" +calendar.get(Calendar.SECOND);
        String date = calendar.get(Calendar.YEAR) + "-" +
                calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);

        QuestionsEntity questionsEntity = new QuestionsEntity(theme, text, email, name, Time.valueOf(time), Date.valueOf(date));
        sessionFactory.getCurrentSession().save(questionsEntity);
    }
}
