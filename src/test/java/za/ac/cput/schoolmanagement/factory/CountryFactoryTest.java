package za.ac.cput.schoolmanagement.factory;
/*
CountryFactoryTest.java
This class implement test cases for Country factory
Siphelele Nyathi 218334028
10.06.2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Country;
import static org.junit.jupiter.api.Assertions.*;


public class CountryFactoryTest {
    @Test
    public void build (){
        Country country = CountryFactory.build ("RSA","south africa");
        System.out.println(country);
        assertNotNull(country);
    }

    @Test
    public void buildWithError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> CountryFactory
                .build(null ,"South Africa"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame(  "country ID is required!", exceptionMessage);

    }
}