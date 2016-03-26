package ru.kpfu.itis.java.Gilmanova.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Pattern;

/**
 * Created by Adel on 19.03.2016.
 */
@Aspect
public class AspectClass {

    @Around("execution(* *..SQL_Handler.execute(String))")
    public Object checkingSQL_injection(ProceedingJoinPoint jp) throws Throwable {
        String query = (String) jp.getArgs()[0];
        String injectionPatterns = "([\\d\\D]+;){2}|([\\d\\D]+ --)|(-1 union [\\d\\D]+)|" +
                "('[\\d\\D]+){2}|([\\d\\D]+ and [\\d\\D]+)|([\\d\\D]+ or [\\d\\D]+)";
        if (Pattern.matches(injectionPatterns, query.toLowerCase())) {
            System.out.println("it is sql injection");
            return null;
        } else {
            return jp.proceed();
        }

    }
}
