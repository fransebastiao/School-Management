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
    public static Student build(String studentId, String email, Name name)
    {
        HelperClass.checkIfObjectNull("Name", name);
        HelperClass.checkEmail(email);

        return new Student.Builder()
                .setStudentId(studentId)
                .setEmail(email)
                .setName(name)
                .build();
    }

}