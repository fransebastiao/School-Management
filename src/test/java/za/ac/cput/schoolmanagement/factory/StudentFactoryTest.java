package za.ac.cput.schoolmanagement.factory;
/*
 School_Management
 Entity for the StudentFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentFactoryTest
{

    Name name = NameFactory.build("Edvalter", "da Costa", "Jamba");

    @Order(1)
    @Test
    public void InvalidEmail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build("edvalter", "invalidEmail", name));
        String exception = e.getMessage();
        System.out.println(exception);
    }

    @Order(2)
    @Test
    public void NullName()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build("edvalter33", "edvalter4@gmail.com", null));
        String eMessage = e.getMessage();
        System.out.println(eMessage);
    }

    @Order(3)
    @Test
    public void ValuesSuccess()
    {
        Student student = StudentFactory.build("Edvalter1", "edvalter@gmail.com", name);
        assertNotNull(student);
        System.out.println(student);
    }

}