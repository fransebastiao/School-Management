package za.ac.cput.schoolmanagement.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.*;
import za.ac.cput.schoolmanagement.services.AddressService.AddressService;
import za.ac.cput.schoolmanagement.services.AddressService.impl.AddressServiceImpl;
import za.ac.cput.schoolmanagement.services.employeeService.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceImplTest {

    private City city = CityFactory.build("AEG903", "Lagos");
    private Address address = AddressFactory.build("36","Vangate", "89",
            "Julius rd", 2000, city);

    @Autowired
    private AddressServiceImpl addressService;

    @BeforeEach
    void setUp() {
        assertNotNull(address);
    }

    @Test
    void save() {
        Address saved = this.addressService.save(this.address);
        assertEquals(this.address, saved);
        System.out.println(saved);
    }

    @Test
    void read() {
        Optional<Address> read = this.addressService.read(this.address.getStreetNumber());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.address,read.get())
        );
        System.out.println(address);
    }

    @Test
    void delete() {
        List<Address> addressList = this.addressService.findAll();
        assertEquals(1,addressList.size());
        System.out.println(addressList);
    }

    @Test
    void findAll() {
        List<Address> addressList = this.addressService.findAll();
        assertEquals(1,addressList.size());
    }

}