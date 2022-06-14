
/* Entity: EMPLOYEEADDRESS
 *(EmployeeAddressRepositoryTesty)
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE
 *  Date: 09/06/2022
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest
{


    @Test
    void getBuildWithSuccess(Address address)
    {
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .build("0791479", address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);

    }
    @Test
    void buildWithError( Address address)
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeAddressFactory.build("0791479", address ));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        //assertSame("staff Id is required",exceptionMessage);

    }
}