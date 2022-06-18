package za.ac.cput.schoolmanagement.factory;

/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressFactoryTest {
    City city = CityFactory.build("1234", "Cape Town");

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
    }
}