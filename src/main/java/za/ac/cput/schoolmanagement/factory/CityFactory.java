package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class  CityFactory {

    public static City build (String cityId, String cityName, Country country ){
        HelperClass.checkStringParam("City ID", cityId);
        HelperClass.checkStringParam("city Name", cityName);
        HelperClass.checkIfObjectNull("address", country);

        return new City.Builder().cityId(cityId).cityName(cityName).Country(country).build();
    }
    public static City.city buildId(City city) {
        return new City.city(
                city.getCityId(),
                city.getCityName(),
                city.getCountry());
    }
}
