/* EmployeeRepository.java
Repository for Employee
Author: Sharfaa Sedick Anthony 220041571
Date: 12 June 2022 */

package za.ac.cput.schoolmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
