package za.ac.cput.schoolmanagement.services.impl;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.services.CityService;
import za.ac.cput.schoolmanagement.services.impl.CityServiceImpl;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {
Country SA;
    private final City city = CityFactory.build("220041571","220041571@mycput.ac.za", SA);

    @Autowired private CityService cityService;


    @Order(1)
    @Test
    void save(){
        City save = this.cityService.save(this.city);
        assertEquals(this.city, save);
        System.out.println(save);
    }
    @Order(2)
    @Test
    void read(){
        Optional<City> read = this.cityService.read(this.city.getCityId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.city,read.get())
        );
    }

    @Order(3)
    @Test
    void delete(){
        this.cityService.deleteById(this.city.getCityId());
        List<City> cityList = this.cityService.findAll();
        assertEquals(0,cityList.size());
    }
    @Order(4)
    @Test
    void findAll(){
        List<City> cityList = this.cityService.findAll();
        assertEquals(1,cityList.size());
    }
}