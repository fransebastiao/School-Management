/* EmployeeAPI.java
Author: Sharfaa Sedick Anthony 220041571
Date: 17 June 2022 */

package za.ac.cput.schoolmanagement.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.services.cityService.CityService;
import za.ac.cput.schoolmanagement.services.employeeAddressService.EmployeeAddressService;
import za.ac.cput.schoolmanagement.services.employeeService.IEmployeeService;
import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeAPI {
    private final EmployeeAddressService employeeAddressService;
    private final IEmployeeService employeeService;
    private final CityService cityService;

    @Autowired public EmployeeAPI(EmployeeAddressService employeeAddressService, IEmployeeService employeeService, CityService cityService){
        this.employeeAddressService = employeeAddressService;
        this.employeeService = employeeService;
        this.cityService = cityService;
    }

    //Question 6:
    public List<Name> findEmployeesInCity(String cityId){
        this.cityService.read(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<EmployeeAddress> allEmployeeAddresses = this.employeeAddressService.findAll();
        List<Employee> foundEmployees = new ArrayList<>();
        List<Name> employeeNames = new ArrayList<>();
        for (var employeeAddress : allEmployeeAddresses){
            if (employeeAddress.getAddress().getCity().getId().equalsIgnoreCase(cityId)){
                foundEmployees.add(employeeService.read(employeeAddress.getStaffId()).get());
            }
        }
        foundEmployees.forEach(employee -> employeeNames.add(employee.getName()));
        return employeeNames;
    }
}