package za.ac.cput.schoolmanagement.factory;

/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    City city = CityFactory.build("1234", "Cape Town");

    @Test
    public void buildWithEmpty() {
        Address address = AddressFactory.build("", "", "15",
                "Ellen avenue", 1000, city);
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void buildWithNull() {
        Address address = AddressFactory.build(null, null, "15",
                "Ellen avenue", 1000, city);
        System.out.println(address);
        assertNotNull(address);
    }
}