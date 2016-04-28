package ru.kpfu.itis.Gilmanova.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Adel on 16.03.2016.
 */
public class StudentRegistrationFormBean {
    @Pattern(regexp = "\\D+", message = "Неверный формат")
    private String lastName;

    @Pattern(regexp = "\\D+", message = "Неверный формат")
    private String firstName;

    private String clazz;

    @Pattern(regexp = "[A-Z][a-z]+[A-Z][A-Z]", message = "Неверный формат")
    private String login;

    @Size(min = 3, max = 8, message = "Пароль должен быть от 3 до 8 символов")
    private String password1;

    @Size(min = 3, max = 8, message = "Пароль должен быть от 3 до 8 символов")
    private String password2;

    public StudentRegistrationFormBean() {
    }

    public StudentRegistrationFormBean(String lastName, String firstName, String login, String password1, String password2) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
