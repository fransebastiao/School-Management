/* StudentAPI.java
Author: Sharfaa Sedick Anthony 220041571
Date: 17 June 2022 */

package za.ac.cput.schoolmanagement.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.services.StudentService.StudentAddressService;
import za.ac.cput.schoolmanagement.services.StudentService.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Component
public class StudentAPI {

    private final StudentService studentService;
    private final StudentAddressService studentAddressService;


    @Autowired
    public StudentAPI(StudentService studentService, StudentAddressService studentAddressService) {
        this.studentService = studentService;
        this.studentAddressService = studentAddressService;

    }

    //Question 8:
    public List<String> findStudentsInCountry(String countryId){
        try {
            List<StudentAddress> allStudentAddresses = studentAddressService.findAll();
            List<StudentAddress> filteredStudentAddress = new ArrayList<>();
            List<Student> allStudents = new ArrayList<>();
            List<String> lastNames = new ArrayList<>();

            for (var studentAddress: allStudentAddresses) {
                if (studentAddress.getAddress().getCity().getCountry().getCountryId().equalsIgnoreCase(countryId)){
                    filteredStudentAddress.add(studentAddress);
                }
            }

            filteredStudentAddress.forEach(studentAddress -> {
                allStudents.add(studentService.read(studentAddress.getStudentId()).get());
            });

            allStudents.forEach(student -> {
                lastNames.add(student.getName().getLastName());
            });

            return lastNames;

        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}