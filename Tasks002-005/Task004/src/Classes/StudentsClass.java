package Classes;

import java.util.ArrayList;

/**
 * Created by Adel on 08.02.2016.
 */
public class StudentsClass {
    private ArrayList<Student> students;
    private Teacher teacher;
    private ArrayList<Subject> subjectList;

    public StudentsClass(ArrayList<Student> students, Teacher teacher, ArrayList<Subject> subjectList) {
        this.students = students;
        this.teacher = teacher;
        this.subjectList = subjectList;
    }

    public StudentsClass(){    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }
}
