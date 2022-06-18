/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressServiceImplTest
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 16-06-2022
 */
package za.ac.cput.schoolmanagement.services.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IEmployeeAddressServiceImplTest
{
    Address khayelitsha;
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("1791479", khayelitsha);


    @Autowired
    private IEmployeeAddressService employeeAddressService;


    @Order(1)
    @Test
    void save()
    {
        EmployeeAddress saved = this.employeeAddressService.save(this.employeeAddress);
        assertEquals(this.employeeAddress, saved);
        System.out.println(saved);
    }

    @Test
    void read()
    {
        Optional<EmployeeAddress> read = this.employeeAddressService.read(this.employeeAddress.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employeeAddress, read.get()));
    }

    @Test
    void delete()
    {
        this.employeeAddressService.deleteById(this.employeeAddress.getStaffId());
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(0, employeeAddressList.size());
    }


    @Test
    void findAll()
    {
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(1, employeeAddressList.size());
    }

}