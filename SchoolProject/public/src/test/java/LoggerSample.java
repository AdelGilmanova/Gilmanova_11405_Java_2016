import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by Adel on 29.04.2016.
 */
public class LoggerSample {
    static Logger logger = Logger.getLogger("SchoolProject");

    public static void main(String[] args) {
        BasicConfigurator.configure();
        for (int i = 0; i < 10; i++) {
            //System.out.println("i=" + i);
            //logger.info("i equals" + i);
            logger.info("i equals" + i);
        }
    }
}
