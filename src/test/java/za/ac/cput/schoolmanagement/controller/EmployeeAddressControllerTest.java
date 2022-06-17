/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressControllerTest
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 16-06-2022
 */
package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressControllerTest
{

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        Address khayelitsha = null;
        assertNotNull(controller);
        this.employeeAddress = EmployeeAddressFactory.build("1791479", khayelitsha);
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/employeeAddress/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate
                .postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read()
    {
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.getForEntity(url, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody()));
    }


    @Test
    void delete()
    {
        String url = baseUrl + "delete/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    void findAll()
    {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response =
        this.restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length));
    }
}
