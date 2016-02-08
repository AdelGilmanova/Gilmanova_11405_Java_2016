/**
 * Created by Adel on 08.02.2016.
 */
public interface Journalable {
    void saveData(int data, Subject subject, Student student);
    void deleteData(int data, Subject subject, Student student);
    void showData(int data, Subject subject, Student student);
}
