package za.ac.cput.schoolmanagement.factory;

/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName
            , int postalCode, City city){
        HelperClass.checkStringParam("streetNumber", streetNumber);
        HelperClass.checkStringParam("streetName", streetName);
        HelperClass.checkStringParam("postalCode", String.valueOf(postalCode));
        HelperClass.checkStringParam("city", String.valueOf(city));
        unitNumber = HelperClass.setEmptyIfNull(unitNumber);
        complexName = HelperClass.setEmptyIfNull(complexName);

        return new Address.Builder().unitNumber(unitNumber).complexName(complexName).streetNumber(streetNumber).
                streetName(streetName).postalCode(postalCode).city(city).build();
    }
}