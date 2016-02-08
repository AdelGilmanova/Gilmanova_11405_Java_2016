/**
 * Created by Adel on 08.02.2016.
 */
public interface Journalable {
    void saveEstimate(int estimate, Subject subject, Student student);
    void deleteEstimate(int estimate, Subject subject, Student student);
    void showEstimate(int estimate, Subject subject, Student student);
}
