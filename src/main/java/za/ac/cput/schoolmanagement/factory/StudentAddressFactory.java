package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.helper.HelperClass;

/*
 School_Management
 Factory for the StudentAddress
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
public class StudentAddressFactory {


    public static StudentAddress createStudentAddress(String studentAdressid, String studentAdress)
    {

        //Validation
        if (HelperClass.isEmptyOrNull(studentAdressid) || HelperClass.isEmptyOrNull(String.valueOf(studentAdress)))
            throw new IllegalArgumentException("Data Required");
        return new StudentAddress.Builder()
                .studentAddressid(studentAdressid)
                .studentAddress(studentAdress)
                .build();

    }


}

