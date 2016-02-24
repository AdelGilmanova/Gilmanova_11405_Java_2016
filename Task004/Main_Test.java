package Tests;

import Classes.Main;
import org.junit.Test;

/**
 * Created by Adel on 24.02.2016.
 */
public class Main_Test {
    @Test
    public void mainMethodShouldBeRight() {
        Main main = new Main();
        Main.main(null);
    }
}
