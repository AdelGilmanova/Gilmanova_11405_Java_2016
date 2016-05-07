package ru.kpfu.itis.Gilmanova.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.kpfu.itis.Gilmanova.gwt.client.MySampleApplicationService;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}