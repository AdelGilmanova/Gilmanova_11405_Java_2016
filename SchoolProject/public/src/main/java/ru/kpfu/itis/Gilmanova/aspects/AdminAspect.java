package ru.kpfu.itis.Gilmanova.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;


/**
 * Created by Adel on 31.03.2016.
 */
@Aspect
@Component
public class AdminAspect {

    @Pointcut("@annotation(ru.kpfu.itis.Gilmanova.aspects.annotations.Admin)")
    public void method() {
    }

    @Around("method()")
    public Object checking(ProceedingJoinPoint jp) throws Throwable {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.equals("anonymousUser")) {
            String role = ((MyUserDetail) user).getUserEntity().getRole();
            if (!role.equals("ROLE_ADMIN")) return "redirect:/";
        }
        return jp.proceed();
    }
}
