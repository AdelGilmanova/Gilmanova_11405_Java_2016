package ru.kpfu.itis.Gilmanova.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.kpfu.itis.Gilmanova.gwt.client.QuestionService;

public class QuestionServiceImpl extends RemoteServiceServlet implements QuestionService {
//    @Autowired
//    private QuestionsService questionsService;

    @Override
    public String addQuestion(String theme, String text, String name, String email) {
        //questionsService.addQuestions(theme, text, email, name);
        return "Ваш вопрос отправлен";
    }

    @Override
    public String message() {
        return null;
    }

}