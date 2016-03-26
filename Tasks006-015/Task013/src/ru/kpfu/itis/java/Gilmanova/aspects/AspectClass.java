package ru.kpfu.itis.java.Gilmanova.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Pattern;

/**
 * Created by Adel on 18.03.2016.
 */
@Aspect
public class AspectClass {

    @Around("execution(* *..MailHandler.setMail(String))")
    public Object checkingMethod(ProceedingJoinPoint jp) throws Throwable {
        String mail = (String) jp.getArgs()[0];
        if (!Pattern.matches(".+@.+\\.[A-Za-z]{2,4}", mail)) {
            System.out.println("It is not email");
            return null;
        } else {
            System.out.println("It is email");
            return jp.proceed();
        }
    }

}
