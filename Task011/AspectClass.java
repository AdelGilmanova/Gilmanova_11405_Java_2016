package ru.kpfu.itis.Adel_Gilmanova.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import ru.kpfu.itis.Adel_Gilmanova.repository.StudentsRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adel on 20.03.2016.
 */
@Aspect
public class AspectClass {
    private HttpServletRequest request;
    private HttpServletResponse response;

	//перед выволнением метода doPost на странице директора выполняется добавление нового студента в бд
    @Before("execution(* *..DirectorsPage.doGet(..))")
    public void includeStudenеt() throws IOException {
        request.setCharacterEncoding("UTF-8");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String cl = request.getParameter("class");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("msg", StudentsRepository.setStudent(first_name, last_name, cl, username, password));
    }

	/* во время выполнения метода doGet на странице директора осуществляется проверка на авторизованность и то, что 
	 * пользователь является дирекором
	 */
    @Around(value = "execution(* *..DirectorsPage.doGet(..))")
    public Object checkingId(ProceedingJoinPoint jp) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) jp.getArgs()[0];
        HttpServletResponse response = (HttpServletResponse) jp.getArgs()[1];
        String id = (String) request.getSession().getAttribute("id");
        if (id != null && Integer.parseInt(id) == 10) {
            return jp.proceed();
        } else {
            response.sendRedirect("/login");
            return null;
        }
    }
}
