import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.MailHandler;

/**
 * Created by Adel on 18.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        MailHandler mh = (MailHandler) ac.getBean("handler");
        mh.setMail("adel.gilm@mail.ru");
        mh.setMail("1111");
    }
}
