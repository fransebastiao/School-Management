package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.helper.HelperClass;

/*
 School_Management
 Factory for the Student
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
public class StudentFactory
{
    public static Student createStudent(String studentid, String studentemail, Name studentname)
    {
        HelperClass.checkStringParam("StudentId", studentid);
        HelperClass.checkStringParam("Email", studentemail);
        HelperClass.checkEmail(studentemail);
        HelperClass.checkIfObjectNull("Name",studentname);

        return new Student.Builder()
                .studentid(studentid)
                .studentemail(studentemail)
                .studentname(studentname)
                .build();

    }
}