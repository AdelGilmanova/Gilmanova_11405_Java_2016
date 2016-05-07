package ru.kpfu.itis.Gilmanova.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MySampleApplicationServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
