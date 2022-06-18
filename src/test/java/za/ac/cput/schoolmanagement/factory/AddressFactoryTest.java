/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressFactoryTest {

    @BeforeEach
    void setUp()
    { }

    @AfterEach
    void tearDown()
    { }

    @Test
    public void createAddressTest()
    {
        Country country = CountryFactory.build("1CNTY1", "South Africa");
        City city = CityFactory.build("1CTY1", "Cape Town", country);

        var results = assertThrows(AssertionError.class, () -> AddressFactory.build("18", null, "412", null, "1818", city));
        var resultsTwo = assertThrows(AssertionError.class, () -> AddressFactory.build("", "Bluebell Village", "412", "Chumani Rd", "1818", city));
        var resultsThree = assertThrows(AssertionError.class, () -> AddressFactory.build("", "Bluebell Village", "412", "Chumani Rd", "1818", null));

        assertThat(results.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsTwo.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsThree.getMessage(), containsString("Invalid value for:"));
        assertDoesNotThrow(() -> AddressFactory.build(
                "18", "Bluebell Village", "412", "Chumani Rd", "1818",
                city
        ));
    }
    /*
    @Test
    @Order(1)
    public void buildWithEmpty() {
        Address address = AddressFactory.build("", "", "15",
                "Ellen avenue", 1000, city);
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    @Order(2)
    public void buildWithNull() {
        Address address = AddressFactory.build(null, null, "15",
                "Ellen avenue", 1000, city);
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    @Order(3)
    public void buildInvalidPostalCode() {
        Address address = AddressFactory.build("928", "Alfred Johnson", "15",
                "Ellen avenue", 6, city);
        System.out.println(address);
        assertNotNull(address);
    }*/
}