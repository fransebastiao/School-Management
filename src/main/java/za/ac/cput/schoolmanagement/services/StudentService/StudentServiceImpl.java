package za.ac.cput.schoolmanagement.services.StudentService;
/*
 School_Management
 StudentService
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public Student save(Student student)
    {
        return this.repository.save(student);
    }
    @Override
    public Optional<Student> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);
    }


    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    public void deleteUsingId(String id) {
        repository.deleteById(id);
        Optional<Student> student = read(id);
        if (student.isPresent()) {
            delete(student.get());
        }
    }
}