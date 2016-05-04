package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;
import ru.kpfu.itis.Gilmanova.repository.QuestionsRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Adel on 07.04.2016.
 */
@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Transactional
    public void addQuestions(String theme, String text, String email, String name) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        calendar.add(Calendar.MONTH, 1);
        String t = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE)+ ":" +calendar.get(Calendar.SECOND);
        String d = calendar.get(Calendar.YEAR) + "-" +
                calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        Time time = Time.valueOf(t);
        Date date = Date.valueOf(d);

        questionsRepository.addQuestions(theme, text, email, name, time, date);
    }

    @Transactional
    public List<QuestionsEntity> getAllQuestions() {
        return questionsRepository.getAllQuestions();
    }

    @Transactional
    public void deleteQuestion(int questionId) {
        questionsRepository.deleteQuestion(questionId);
    }
}
