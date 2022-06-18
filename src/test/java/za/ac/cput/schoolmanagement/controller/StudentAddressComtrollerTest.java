package za.ac.cput.schoolmanagement.controller;
/*
 School_Management
 StudentAddressComtrollerTest
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
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressComtrollerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressComtroller controller;
    @Autowired private TestRestTemplate restTemplate;
    private StudentAddress studentaddress;
    private Address address;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.address = AddressFactory.build("12A","JHG","12b","alexender",1,null);
        this.studentaddress = StudentAddressFactory.createStudentAddress("1",address);
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/employee/";
    }



    @Test
    void A_save() {

        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, this.studentaddress, StudentAddress.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK,response.getStatusCode()),() -> assertNotNull(response.getBody())
        );


    }

    @Test
    void B_delete() {
        String url = baseUrl + "delete/" + this.studentaddress.getstudentAddressid();
        System.out.println(url);
        this.restTemplate.delete(url);

    }

    @Test
    void C_read() {

        String url = baseUrl + "read/" + this.studentaddress.getstudentAddressid();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url, StudentAddress.class);
        System.out.println(response);
        assertAll(()-> assertEquals(HttpStatus.OK, response.getStatusCode()),()-> assertNotNull(response.getBody())
        );

    }
}