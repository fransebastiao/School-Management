/*
CountryFactory.java
This class implement factory for Country
Siphelele Nyathi 218334028
10.06.2022
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.HelperClass;


public class CountryFactory {
    public static Country build(String countryId, String countryName)
    {
        HelperClass.checkStringParam("countryId",countryId);
        HelperClass.checkStringParam("countryName", countryName);
        return new Country.Builder().setCountryId(countryId).setCountryName (countryName).build();
    }

}