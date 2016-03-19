package ru.kpfu.itis.java.Gilmanova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.SQL_Handler;

/**
 * Created by Adel on 19.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        SQL_Handler handler = ac.getBean(SQL_Handler.class);
        handler.execute("')+and+(news_id_author='1");
        handler.execute("-1 UNION SELECT 1,username, password,1 FROM admin");
        handler.execute("-1 UNION SELECT password FROM admin --");
        handler.execute("12;INSERT INTO admin (username, password) VALUES ('HaCkEr', 'foo');");
        handler.execute("-1 OR 1=1");
        handler.execute("1");
    }
}
