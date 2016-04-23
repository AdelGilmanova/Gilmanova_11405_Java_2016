import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Adel on 15.03.2016.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Calendar data = new GregorianCalendar();
        System.out.println(data.getWeekYear());
    }
}
// md5('555')=15de21c670ae7c3f6f3f1f37029303c9;