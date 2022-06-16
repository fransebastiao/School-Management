/* NameFactoryTest.java
Test for NameFactory
Author: Sharfaa Sedick Anthony 220041571
Date: 12 June 2022 */

package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Name;
import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    public void buildWithNullNameAndSuccess(){
        Name name = NameFactory.build("Sharfaa",null, "Anthony");
        assertAll(
                ()-> assertTrue(name.getMiddleName().isEmpty()),
                ()-> assertNotNull(name)
        );
        assertTrue(name.getMiddleName().isEmpty());
        System.out.println(name);
    }

    @Test
    public void buildWithCompletedValues(){
        Name name = NameFactory.build("Sharfaa", "Sedick", "Anthony");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    public void buildError(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                NameFactory.build("","Sedick","Anthony"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}