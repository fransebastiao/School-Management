package za.ac.cput.schoolmanagement.services.StudentService;
/*
 School_Management
 StudentAddressServiceImplTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

    private final Address address = AddressFactory.build("12A","JHG","12b","alexender",1,null);
    private final StudentAddress studentAddress = StudentAddressFactory.createStudentAddress("12",address);

    @Autowired
    private StudentAddressService studentaddressService;


    @Test
    void A_save() {
        StudentAddress saved = this.studentaddressService.save(this.studentAddress);
        assertEquals(this.studentAddress, saved);
        System.out.println(saved);
    }

    @Test
    void B_read()
    {
        Optional<StudentAddress> read = this.studentaddressService.read(this.studentAddress.getstudentAddressid());
        assertAll(()-> assertTrue(read.isPresent()),()-> assertEquals(this.studentAddress,read.get()));
    }

    @Test
    void C_delete() {

        this.studentaddressService.deleteUsingId(this.studentAddress.getstudentAddressid());
        List<StudentAddress> showStudents = this.studentaddressService.findAll();
        assertEquals(0,showStudents.size());
    }

    @Test
    void D_findAll() {
        List<StudentAddress> showStudents = this.studentaddressService.findAll();
        assertEquals(1,showStudents.size());
    }



/*
    @Mock
    private StudentRepository studentRepository;

    StudentService studentService;

    @BeforeEach
    void initUseCase() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void save() {
        Student student = new Student();
        student.getStudentname();
        student.getStudentid();
        student.getStudentname();
        when(StudentRepository.save(any(Student.class))).thenReturn(new student);

        Student saved = StudentRepository.save(student);
        assertThat(saved.getStudentname()).isNotNull();
    }

    private ArgumentMatchers assertThat(String studentname) {
        return null;
    }
    */

}