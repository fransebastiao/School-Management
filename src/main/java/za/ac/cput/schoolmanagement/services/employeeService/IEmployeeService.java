/* IEmployeeService.java
Service interface for the Employee
Author: Sharfaa Sedick Anthony 220041571
Date: 14 June 2022 */

package za.ac.cput.schoolmanagement.services.employeeService;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.services.IService;
import java.util.Optional;


public interface IEmployeeService extends IService<Employee, String> {
    void deleteById(String id);
    Optional<Employee> findByEmail(String email);

}