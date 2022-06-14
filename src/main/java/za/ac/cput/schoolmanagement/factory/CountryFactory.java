package za.ac.cput.schoolmanagement.factory;
/*
CountryFactory.java
This class implement factory for Country
Siphelele Nyathi 218334028
10.06.2022
 */
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.HelperClass;
import java.util.Random;

public class CountryFactory {

    public static Country buildCountry(String countryName){

        Random random = new Random();
        String countryId = "X" +random.nextInt(6666);

        if(HelperClass.isEmptyOrNull(countryName)){
            throw new IllegalArgumentException("countryName");
        }
        else{
            Country country = new Country.Builder()
                    .setCountryId(countryId)
                    .setCountryName(countryName)
                    .build();

            return country;
        }

    }
}
