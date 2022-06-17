package za.ac.cput.schoolmanagement.factory;
/*
CountryFactoryTest.java
This class implement test cases for Country factory
Siphelele Nyathi 218334028
10.06.2022
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Country;
import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    Country country;

    @Test
    @DisplayName("Should build country with success")
    @Order(3)
    public void buildWithSuccess(){

        country = CountryFactory.buildCountry( "X6596", "Jamaica");
        assertNotNull(country);

        System.out.println(country);

    }

    @Test
    @DisplayName("Should return an error, must include ID of the country to return object ")
    @Order(1)
    public void buildWithFailure(){

        country = CountryFactory.buildCountry( "", "Jamaica");

        assertNull(country);
        System.out.println(country);
    }

    @Test
    @DisplayName("Should return an error, Country objects cannot be null or empty ")
    @Order(2)
    public void buildWithEmptyObjects(){

        country = CountryFactory.buildCountry( "", null);
        System.out.println(country);

        assertNull(country);
    }

}