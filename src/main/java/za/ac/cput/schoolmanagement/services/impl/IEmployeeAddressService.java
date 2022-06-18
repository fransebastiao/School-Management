package za.ac.cput.schoolmanagement.services.impl;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.services.IService;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String>
{
        List<EmployeeAddress> findAll();
        void deleteById(String id);
        }