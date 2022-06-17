package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.services.CityService;
import za.ac.cput.schoolmanagement.services.impl.CityServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CityControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private CityController controller;
    @Autowired private TestRestTemplate restTemplate;
    private  City city;
    private String baseUrl;
    Country SA;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.city = CityFactory.build("7925","Cape Town", SA);
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/city/";
    }
    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.city.getCityId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }


    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.city.getCityId();
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate.getForEntity(url, City.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Order(4)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<City[]> response =
                this.restTemplate.getForEntity(url, City[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}