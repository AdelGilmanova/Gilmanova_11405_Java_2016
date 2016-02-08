/**
 * Created by Adel on 08.02.2016.
 */
public interface Teacherable {
    void teach(Subject subject, StudentsClass studentsClass, int hours);
    void expel(Student student, Subject subject, int estimate);
    void pullEstimate(int estimate, Subject subject, Student student);
}
