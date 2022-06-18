package za.ac.cput.schoolmanagement.services.StudentService;
/*
 School_Management
 StudentServiceImplTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;
import za.ac.cput.schoolmanagement.services.employeeService.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    private final Name name = NameFactory.build("Edvalter", "Costa","Jamba");
    private final Student student = StudentFactory.createStudent("12","220446571@mycput.ac.za",name);

    @Autowired
    private StudentService studentService;

    @Test
    void A_save() {
        Student saved = this.studentService.save(this.student);
        assertEquals(this.student, saved);
        System.out.println(saved);
    }
    @Test
    void B_read() {
        Optional<Student> read = this.studentService.read(this.student.getStudentid());
        assertAll(()-> assertTrue(read.isPresent()), ()-> assertEquals(this.student,read.get())
        );
    }

    @Test
    void C_delete() {
        this.studentService.deleteUsingId(this.student.getStudentid());
        List<Student> showStudents = this.studentService.findAll();
        assertEquals(0,showStudents.size());
    }
    @Test
    void D_findAll() {
        List<Student> showStudents = this.studentService.findAll();
        assertEquals(1,showStudents.size());
    }
}