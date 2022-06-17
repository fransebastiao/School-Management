
/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressRepositoryTesty
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 09/06/2022
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest
{

    Address khayelitsha;

    @Test
    public void buildWithNullAddress()
    {    Exception exception = assertThrows(IllegalArgumentException.class, () ->
         EmployeeAddressFactory.build("0791479",null));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    public void buildWithValidStaffId()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        EmployeeAddressFactory.build("0791479", khayelitsha));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }


    @Test
    public void BuildWithSuccess()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        EmployeeAddressFactory.build("0791479", khayelitsha));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);

        //assert
    }
}