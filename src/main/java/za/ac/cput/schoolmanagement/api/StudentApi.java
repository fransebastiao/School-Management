package za.ac.cput.schoolmanagement.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.services.StudentService.StudentAddressService;
/*
 School_Management
 StudentApi/ for FACADE
 Author: Edvalter da Costa Jamba (220446571)
 Date: 17 June 2022
*/
import java.util.Optional;

@Component
public class StudentApi {


    private final StudentAddressService studentAddressService;

    @Autowired
    public StudentApi(StudentAddressService studentAddressService) {
        this.studentAddressService = studentAddressService;
    }

    public StudentAddress save(StudentAddress student)
    {
        Optional<StudentAddress> read = this.studentAddressService.read(StudentAddress.getstudentAddressid());
        if (read.isPresent())
        {
            Optional<ity>city  = this.studentAddressService.read(StudentAddress.getstudentAddressid());
            if (city.isPresent())
            {
                return this.studentAddressService.save(student);
            }return null;
        }
        return null;
    }


}
