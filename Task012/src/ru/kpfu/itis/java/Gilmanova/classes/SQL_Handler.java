package ru.kpfu.itis.java.Gilmanova.classes;

/**
 * Created by Adel on 19.03.2016.
 */
public class SQL_Handler {
    private String query = "select * from users where id=";

    public SQL_Handler() {
    }

    public void execute(String parameter) {
        System.out.println(query + parameter);
        System.out.println("sql query was executed");
    }
}
