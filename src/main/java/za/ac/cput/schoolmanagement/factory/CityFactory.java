package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class CityFactory {

    public static City build(String  id, String name, Country country)throws IllegalArgumentException{
        HelperClass.checkStringParam("id",id);
        HelperClass.checkStringParam("name",name);
        HelperClass.checkIfObjectNull("Country",country);
        return new City.Builder().setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }
}