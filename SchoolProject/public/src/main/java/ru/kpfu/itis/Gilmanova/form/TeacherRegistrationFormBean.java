package ru.kpfu.itis.Gilmanova.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Adel on 16.03.2016.
 */
public class TeacherRegistrationFormBean {
    @Pattern(regexp = "\\D+", message = "Неверный формат")
    private String lastName;

    @Pattern(regexp = "\\D+", message = "Неверный формат")
    private String firstName;

    @Pattern(regexp = "\\D+", message = "Неверный формат")
    private String secondName;

    private String gender;
    private String day;
    private String month;
    private String year;

    @Pattern(regexp = "[A-Z][a-z]+[A-Z][A-Z]", message = "Неверный формат")
    private String login;

    @Size(min = 3, max = 8, message = "Пароль должен быть от 3 до 8 символов")
    private String password1;

    @Size(min = 3, max = 8, message = "Пароль должен быть от 3 до 8 символов")
    private String password2;

    public TeacherRegistrationFormBean() {
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
