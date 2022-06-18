package za.ac.cput.schoolmanagement.controller;
/*
 School_Management
 StudentControllerTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 17 June 2022
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest
{
    @LocalServerPort
    private int p;

    @Autowired
    private StudentController control;
    @Autowired
    private TestRestTemplate restTemplate;

    private Name name;
    private Student student;
    private String Url;


    @BeforeEach
    void setUp()
    {
        assertNotNull(control);
        this.name = NameFactory.build("Edvalter", "da Costa", "Jamba");
        this.student = StudentFactory.build("edvalter33", "edvalter@gmail.com", name);
        this.Url = "http://localhost:" + this.p + "/school-management/student/";
    }

    @Order(1)
    @Test
        //save
    void save()
    {
        String url = Url + "save";
        System.out.println(url);

        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(url, this.student, Student.class);
        System.out.println(response);

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    @Order(2)
    @Test
        //reading
    void read()
    {
        String url = Url + "delete" + this.student.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
        // finding
    void findAll()
    {
        String url = Url + "findAll";
        System.out.println(url);

        ResponseEntity<Student[]> response = this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertEquals(1, response.getBody().length)
                );
    }

    @Order(4)
    @Test
        // deleting
    void delete()
    {
        String url = Url + "delete" + this.student.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

}