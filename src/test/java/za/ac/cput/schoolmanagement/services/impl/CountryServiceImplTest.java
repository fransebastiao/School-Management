package za.ac.cput.schoolmanagement.services.impl;
/*
CountryServiceImplTest.java
JUnit tests  for Country Services Implementation
Siphelele Nyathi 218334028
15.06.2022
 */
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.repository.CountryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
@SpringBootConfiguration
class CountryServiceImplTest {

    @Autowired private CountryServiceImpl service;

    @MockBean private CountryRepository repository;
    private Country country;


    @BeforeAll
    void setUp(){
        this.country = CountryFactory.buildCountry("X5566", "South Africa");
        Country savedCountry = service.save(country);
        System.out.println("Countries => " + savedCountry);

        assertNotNull(savedCountry);
        assertEquals(country, savedCountry);
    }

    @Test
    void save() {

        country = CountryFactory.buildCountry("X0011", "Jamaica");
        this.repository.save(country).getCountryId();
        this.service.save(country).getCountryId();
        System.out.println(country);

        assertNotNull(country, "Country should not be null");
    }

    @Test
    void read() {

        Optional<Country> read = this.service.read(country.getCountryId());
        System.out.println(read);

        assertTrue(read.isPresent());
        assertEquals(this.country, read.get());
    }

    @Test
    void delete() {
        this.repository.delete(country);
        this.service.delete(country);

        Mockito.verify(service).delete(country);

        assertNotNull(country, "Country should be empty");
    }

    @Test
    void findAll() {

        country = CountryFactory.buildCountry("X1122", "Lesotho");
        Country country1 = CountryFactory.buildCountry("X2233", "Swaziland");
        Country country2 = CountryFactory.buildCountry("X3344", "Botswana");
        List<Country> countryList = Arrays.asList(country, country1, country2);
        doReturn(countryList).when(repository).findAll();

        List<Country> countries = (List<Country>) service.findAll();

        assertEquals(3, countries.size(), "Should return 3 countries");
    }

    @Test
    @DisplayName("Test findById")
    void findByIdSuccess(){

        //country = CountryFactory.buildCountry("X1122", "Lesotho");
        //doReturn(Optional.of(country)).when(repository).findById(country.getCountryId());

        String expected = "X0000";

        RestTemplate restTemplate = new RestTemplate();
        country = restTemplate.getForObject("http://localhost:8080/countries/1",Country.class);

        String actual = country.getCountryName();
        System.out.println(actual);

        assertEquals(expected, actual);

    }
}