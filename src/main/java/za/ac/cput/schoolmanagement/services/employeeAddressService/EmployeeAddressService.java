/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressServiceImpl
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 16/06/2022
 */

package za.ac.cput.schoolmanagement.services.employeeAddressService;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.services.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String>
{
    List<EmployeeAddress> findAll();
    void deleteById(String id);
}