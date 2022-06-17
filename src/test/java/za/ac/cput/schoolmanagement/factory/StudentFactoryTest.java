package za.ac.cput.schoolmanagement.factory;
/*
 School_Management
 Entity for the StudentFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    Name studentname = NameFactory.build("Edvalter","Costa","Jamba");

    @Test
    void createStudent() {
            Student student=StudentFactory.createStudent("1","220446571@mycput.ac.za",studentname);
            System.out.println(student.toString());
            assertNotNull(student);
    }


}