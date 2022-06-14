/* Entity: EMPLOYEEADDRESS
 *(EmployeeAddressRepository)
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE
 *  Date: 09/06/2022
 */

package za.ac.cput.schoolmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String>
{}
