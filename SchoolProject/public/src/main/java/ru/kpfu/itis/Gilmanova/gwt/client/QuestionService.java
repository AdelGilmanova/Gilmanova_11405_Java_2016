package ru.kpfu.itis.Gilmanova.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("QuestionService")
public interface QuestionService extends RemoteService {
	String addQuestion(String theme, String text, String name, String email);
	String message();

	class App {
		private static QuestionServiceAsync ourInstance = GWT.create(QuestionService.class);

		public static synchronized QuestionServiceAsync getInstance() {
			return ourInstance;
		}
	}
}