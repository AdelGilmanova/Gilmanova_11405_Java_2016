package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.repository.QuestionsRepository;

/**
 * Created by Adel on 07.04.2016.
 */
@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Transactional
    public void addQuestions(String theme, String text, String email, String name) {
        questionsRepository.addQuestions(theme, text, email, name);
    }
}
