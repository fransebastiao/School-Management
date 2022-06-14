/* Entity: EMPLOYEEADDRESS
 *(EmployeeAddressFactory)
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE
 *  Date: 09/06/2022
 */

package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class EmployeeAddressFactory
{
    public static EmployeeAddress build(String staffId, Address address)
    {
        HelperClass.checkStringParam("staffId", staffId);
        HelperClass.checkIfObjectNull("address", address);

        return new EmployeeAddress.Builder()
                .staffId(staffId).address(address).build();
    }
}
