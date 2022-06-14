/* EmployeeFactory.java
Factory for the Employee
Author: Sharfaa Sedick Anthony 220041571
Date: 11 June 2022 */

package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {

        HelperClass.checkStringParam("Staff Id", staffId);
        HelperClass.checkStringParam("Email", email);
        HelperClass.checkEmail(email);
        HelperClass.checkIfObjectNull("Name",name);

        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
}