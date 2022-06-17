package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.factory.AddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private AddressController addressController;
    @Autowired private TestRestTemplate restTemplate;
    private Address address;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(addressController);
        this.address = AddressFactory.build("", "", "12",
                "test", 1000, address.getCity());
        this.baseUrl = "http://localhost:" + this.port + "schoolmanagement/address/";
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate
                .postForEntity(url, this.address, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.address.getStreetNumber();
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate.getForEntity(url, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.address.getStreetNumber();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Address[]> response =
                this.restTemplate.getForEntity(url, Address[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}