/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressServiceImpl
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 16-06-2022
 */
package za.ac.cput.schoolmanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.services.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeAddressServiceImpl implements IEmployeeAddressService
{
    private final EmployeeAddressRepository repository;

    @Autowired
    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress)
    {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress)
    {
        this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll()
    {
        return this.repository.findAll();
    }

    public void deleteById(String id)
    {
        repository.deleteById(id);
        Optional<EmployeeAddress> employeeAddress = read(id);
        if (employeeAddress.isPresent())
        {
            delete(employeeAddress.get());
        }
    }
}
