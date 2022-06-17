package za.ac.cput.schoolmanagement.services;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String>
{
        List<EmployeeAddress> findAll();
        void deleteById(String id);
        }