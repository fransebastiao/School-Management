package za.ac.cput.schoolmanagement.factory;
/*
 School_Management
 Entity for the StudentAddressFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;

class StudentAddressFactoryTest {

    @Test
    void buildWithSuccess() throws IllegalArgumentException{
        Country country = CountryFactory.build("gsd1", "South Africa");
        City city = CityFactory.build("cty", "Cape Town", country);
        Address address = AddressFactory.build("201","Johns", "48", "Label Street", "1241", city);

        StudentAddress studentAddress = StudentAddressFactory
                .build("fghj", address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    void buildWithError() {
        Country country = CountryFactory.build("gsd1", "South Africa");
        City city = CityFactory.build("cty", "Cape Town", country);
        Address address = AddressFactory.build("201","Johns", "48", "Label Street", "1241", city);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory
                        .build(null, address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student id is required!", exceptionMessage);
    }
}