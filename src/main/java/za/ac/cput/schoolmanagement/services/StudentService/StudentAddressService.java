package za.ac.cput.schoolmanagement.services.StudentService;
/*
 School_Management
 StudentAddressService
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.services.IService;

public interface StudentAddressService extends IService<StudentAddress, String> {
        void deleteById(String id);

        void deleteUsingId(String id);
}