package za.ac.cput.schoolmanagement.factory;
/*
        School_Management
        StudentAddressFatoryTest
        Author: Edvalter da Costa Jamba (220446571)
        Date: 12 June 2022
  */
import org.junit.Test;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {
    @Test
    public void test()
    {
        StudentAddress studentaddress=StudentAddressFactory.createStudentAddress("1","Western Cape");
        System.out.println(studentaddress.toString());
        assertNotNull(studentaddress);
    }
}