package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    private City city;
    Country SA;

    @Test
    public void BuildWithSucess() {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        CityFactory.build("7925", "CapeTown", SA));
        String exceptionMessage = exception.getMessage();
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    void buildWithFailure() {
        

    }
}