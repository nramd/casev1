package casev1.Services;
import casev1.Student.Student;
import casev1.interfaces.StudentRepository;

public class MySqlStudentRepository implements StudentRepository {
    @Override
    public void saveOrder(Student student, double amount) {
        System.out.println("--> Saving order to MySQL for " + student.getName() + " with amount " + amount);
    }

    @Override
    public boolean studentExists(String id) {
        System.out.println("--> Checking existence for student ID: " + id);
        return true; 
    }
}
