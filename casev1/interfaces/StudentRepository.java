package casev1.interfaces;
import casev1.Student.Student;

public interface StudentRepository {
    void saveOrder(Student student, double amount);
    boolean studentExists(String id);
}