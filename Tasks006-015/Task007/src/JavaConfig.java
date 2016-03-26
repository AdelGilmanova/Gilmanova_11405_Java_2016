import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.java.Gilmanova.classes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adel on 17.03.2016.
 */
@Configuration
@ComponentScan(basePackages = "ru.kpfu.itis.java.Gilmanova.classes")
public class JavaConfig {
    @Autowired
    @Qualifier("director")
    Director director;

    @Autowired
    @Qualifier("teacher")
    Teacher teacher;

    @Autowired
    @Qualifier("diary")
    Diary diary;

    @Autowired
    @Qualifier("Valiev")
    Student valiev;

    @Autowired
    @Qualifier("history")
    Subject history;

    @Autowired
    @Qualifier("russian")
    Subject russian;

    @Autowired
    StudentsClass studentsClass;

    @Bean(name = "teacher")
    public Teacher teacher() {
        Teacher teacher = new Teacher();
        teacher.setFIO("Садыков Жаудат Назипович");
        teacher.setWorkExperience((double) 25);
        return teacher;
    }

    @Bean(name = "director")
    public Director director() {
        Director director = new Director();
        director.setFIO("Тигина Ольга Александровна");
        director.setWorkExperience((double) 25);
        return director;
    }

    @Bean(name = "history")
    public Subject history() {
        Subject history = new Subject();
        history.setProfile("history");
        history.setTeacher(teacher);
        return history;
    }

    @Bean(name = "russian")
    public Subject russian() {
        Subject russian = new Subject();
        russian.setProfile("russian");
        russian.setTeacher(director);
        return russian;
    }

    @Bean(name = "Valiev")
    public Student valiev() {
        Student valiev = new Student();
        valiev.setFIO("Валиев Ильдар Маратович");
        valiev.setDiary(diary);
        valiev.setStudentsClass(studentsClass);
        return valiev;
    }

    @Bean(name = "diary")
    public Diary diary() {
        Diary diary = new Diary();
        diary.setStudent(valiev);
        return diary;
    }

    @Bean(name = "schdule")
    public Schedule schedule() {
        Schedule schedule = new Schedule();
        schedule.setStudentsClass(studentsClass);
        schedule.setWeekday("monday");
        List<Subject> list = new ArrayList<>();
        list.add(russian);
        list.add(history);
        schedule.setSubjectList(list);
        schedule.setStudentsClass(studentsClass);
        return schedule;
    }


}
