package ru.kpfu.itis.Gilmanova.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by Adel on 31.03.2016.
 */
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(ru.kpfu.itis.Gilmanova.aspects.annotations.Logger)")
    public void method() {
    }

    @Before("method()")
    public void logging() {
        Logger logger = Logger.getLogger("SchoolProject");
        //BasicConfigurator.configure();
        logger.info("Controller method is ready to work.");
    }
}
