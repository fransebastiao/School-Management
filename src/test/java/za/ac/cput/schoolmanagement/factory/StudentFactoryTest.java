package za.ac.cput.schoolmanagement.factory;
/*
 School_Management
 Student_FatoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 12 June 2022
*/
import org.junit.Test;
import za.ac.cput.schoolmanagement.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest
{
    @Test
    public void test()
    {
        Student student=StudentFactory.createStudent("1","220446571@mycput.ac.za"," ");
        System.out.println(student.toString());
        assertNotNull(student);
    }
}