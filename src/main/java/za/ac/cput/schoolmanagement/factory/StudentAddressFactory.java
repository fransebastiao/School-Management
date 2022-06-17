package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.helper.HelperClass;

/*
 School_Management
 Factory for the StudentAddress
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
public class StudentAddressFactory {


    public static StudentAddress createStudentAddress(String studentAdressid, Address studentAdress)
    {
        HelperClass.checkStringParam("StudentId", studentAdressid);
        HelperClass.checkStringParam("Address", String.valueOf(studentAdress));
        return new StudentAddress.Builder()
                .studentAddressid(studentAdressid)
                .build();

    }


}

