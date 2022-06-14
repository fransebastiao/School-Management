/* EmployeeFactoryTest.java
Test for EmployeeFactory
Author: Sharfaa Sedick Anthony 220041571
Date: 12 June 2022 */

package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    Name name = NameFactory.build("Sharfaa","Sedick","Anthony");

    @Test
    @Order(1)
    public void buildWithNullName(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("220041571","220041571@mycput.ac.za",null));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(2)
    public void buildWithInvalidEmail(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("2200415711","Test",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(3)
    public void buildWithEmptyStaffId(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("","220041571@mycput.ac.za",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(4)
    public void buildWithSuccess(){
        Employee employee = EmployeeFactory.build("220041571", "220041571@mycput.ac.za",name);
        assertNotNull(employee);
        System.out.println(employee);
    }
}