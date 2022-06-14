package za.ac.cput.schoolmanagement.factory;
/*
CountryFactoryTest.java
This class implement test cases for Country factory
Siphelele Nyathi 218334028
10.06.2022
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Country;
import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    @DisplayName("Should build country with success")
    public void buildWithSuccess(){

        Country country = CountryFactory.buildCountry( "Jamaica");
        assertNotNull(country);

        System.out.println(country);

    }

    @Test
    @DisplayName("Should return an error, must include name of the country to return object ")
    public void buildWithFailure(){

        Country country = CountryFactory.buildCountry( "");

        assertEquals(null, country);
        System.out.println(country);
    }

}