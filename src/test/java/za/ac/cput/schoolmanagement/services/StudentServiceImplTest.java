package za.ac.cput.schoolmanagement.services;
/*
 School_Management
 StudentServiceImplTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.*;
import za.ac.cput.schoolmanagement.services.StudentService.StudentService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest
{
    Name name = NameFactory.build("Edvalter", "", "Jamba");
    Student student = StudentFactory.build("Edvalter33", "Edvalter@gmail.com", name);


    @Autowired private StudentService s;

    @Order(1)
    @Test
    void save()
    {
        Student created = this.s.save(this.student);
        System.out.println(created);
    }

    @Order(2)
    @Test
    void read()
    {
        Optional<Student> read = this.s.read(student.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()), () -> assertEquals(this.student, read.get())
        );
        System.out.println(read);
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<Student> listStudents = this.s.findAll();
        assertEquals(1, listStudents.size());
        System.out.println(listStudents);
    }

    @Order(4)
    @Test
    void delete()
    {
        this.s.deleteById(this.student.getStudentId());
        List<Student> ListStudent = this.s.findAll();
        assertEquals(0, ListStudent.size());
    }
}