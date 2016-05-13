package ru.kpfu.itis.Gilmanova.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface QuestionServiceAsync {
    void addQuestion(String theme, String text, String name, String email, AsyncCallback<String> callback);
    void message(AsyncCallback<String> callback);
}