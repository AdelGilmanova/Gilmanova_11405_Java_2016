package ru.kpfu.itis.Gilmanova.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class EntryPointApp implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final TextBox theme = new TextBox();
        theme.setVisibleLength(50);
        final TextArea text = new TextArea();
        text.setCharacterWidth(50);
        text.setVisibleLines(10);
        final TextBox name = new TextBox();
        name.setVisibleLength(50);
        final TextBox email = new TextBox();
        email.setVisibleLength(50);
        final Button addButton = new Button("Добавить");

        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (!theme.getText().isEmpty() && !text.getText().isEmpty()
                        && !name.getText().isEmpty() && !email.getText().isEmpty()) {
                    QuestionService.App.getInstance().addQuestion(theme.getText(), text.getText(),
                            name.getText(), email.getText(), new MyAsyncCallback("yes"));
                    theme.setText("");
                    text.setText("");
                    name.setText("");
                    email.setText("");
                } else {
                    QuestionService.App.getInstance().message(new MyAsyncCallback("no"));
                }
            }
        });

        RootPanel.get("theme").add(theme);
        RootPanel.get("text").add(text);
        RootPanel.get("name").add(name);
        RootPanel.get("email").add(email);
        RootPanel.get("add").add(addButton);

    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        String value;

        MyAsyncCallback(String value) {
            this.value = value;
        }

        public void onSuccess(String result) {
            if (value.equals("yes")) Window.alert("Ваш вопрос отправлен.");
            if (value.equals("no")) Window.alert("Заполните все поля.");
        }

        public void onFailure(Throwable throwable) {
            Window.alert("Приносим извинения. На сервере произошла ошибка.");
        }
    }
}
