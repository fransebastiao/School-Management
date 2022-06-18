/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */
package za.ac.cput.schoolmanagement.factory;

import lombok.extern.slf4j.Slf4j;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.HelperClass;
import java.lang.reflect.Field;

@Slf4j
public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        validateAttributes(unitNumber, complexName, streetNumber, streetName, postalCode, city);
        return new Address.Builder().setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city).build();
    }

    private static void validateAttributes(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        HelperClass.checkStringParam("unitNumber", unitNumber);
        HelperClass.checkStringParam("complexName", complexName);
        HelperClass.checkStringParam("streetNumber", streetNumber);
        HelperClass.checkStringParam("streetName", streetName);
        HelperClass.checkStringParam("postalCode", postalCode);
        //validatePostalCode(postalCode);
        HelperClass.checkIfObjectNull("city", city);
    }

    private static void validatePostalCode(String postalCode) throws IllegalArgumentException
    {
        checkPostalCodeLength(postalCode);
        checkNonDigitCharacters(postalCode);
    }

    private static void checkPostalCodeLength(String postalCode) throws IllegalArgumentException
    {
        if(postalCode.length() != 4)
            throw new IllegalArgumentException("Invalid postal code length");
    }

    private static void checkNonDigitCharacters(String postalCode) throws IllegalArgumentException
    {
        int count = 0;
        for (int i = 0; i < postalCode.length(); i++)
        {
            if(!Character.isDigit(postalCode.charAt(i)))
                ++count;
        }

        if(count > 0)
            throw new IllegalArgumentException("Invalid postal code, " + "'" + getFieldName() + "'" + " contains: " + count + " invalid characters");
    }
        /*unitNumber = HelperClass.setEmptyIfNull(unitNumber);
        complexName = HelperClass.setEmptyIfNull(complexName);
        HelperClass.validatePostalCode(postalCode);*/

    private static String getFieldName()
    {
        try{
            Field field = Address.class.getDeclaredField("postalCode");
            return field.getName();
        }
        catch(Exception e)
        {
            log.info("getFieldName procedure: {}", e);
        }
        return "";
    }
} 