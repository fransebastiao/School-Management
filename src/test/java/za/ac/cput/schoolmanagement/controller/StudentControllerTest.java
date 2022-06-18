package za.ac.cput.schoolmanagement.controller;
/*
 School_Management
 StudentControllerTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 17 June 2022
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {



    @LocalServerPort
    private int port;

    @Autowired
    private StudentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Student student;
    private Name name;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.build("Edvalter", "Costa","Jamba");
        this.student = StudentFactory.createStudent("220446571","220446571@mycpur.ac.za",name);
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/employee/";
    }

    @Test
    void A_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(url, this.student, Student.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK,response.getStatusCode()),() -> assertNotNull(response.getBody())
        );

    }

    @Test
    void B_delete() {
        String url = baseUrl + "delete/" + this.student.getStudentid();
        System.out.println(url);
        this.restTemplate.delete(url);

    }

    @Test
    void C_read() {
        String url = baseUrl + "read/" + this.student.getStudentid();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response);
        assertAll(()-> assertEquals(HttpStatus.OK, response.getStatusCode()),()-> assertNotNull(response.getBody())
        );
    }
}