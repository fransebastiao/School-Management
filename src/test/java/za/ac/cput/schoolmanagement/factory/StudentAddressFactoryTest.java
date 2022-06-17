package za.ac.cput.schoolmanagement.factory;
/*
 School_Management
 Entity for the StudentAddressFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {
Address address= AddressFactory.build("12A","JHG","12b","alexender",1,null);

    @Test
    void createStudentAddress() {

        StudentAddress student=StudentAddressFactory.createStudentAddress("1",address);
        System.out.println(student.toString());
        assertNotNull(student);

    }
}