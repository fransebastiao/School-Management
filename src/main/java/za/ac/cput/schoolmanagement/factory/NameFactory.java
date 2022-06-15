/* NameFactory.java
Factory for Name
Author: Sharfaa Sedick Anthony 220041571
Date: 11 June 2022 */

package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName){

        HelperClass.checkStringParam("First Name", firstName);
        HelperClass.checkStringParam("Last Name", lastName);
        middleName = HelperClass.setEmptyIfNull(middleName);

        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }
}