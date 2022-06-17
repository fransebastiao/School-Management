package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.HelperClass;

public class  CityFactory {

    public static City build (String cityId, String cityName ){
        HelperClass.checkStringParam("City ID", cityId);
        HelperClass.checkStringParam("city Name", cityName);


        return new City.Builder().cityId(cityId).cityName(cityName).build();
    }
    public static City.city buildId(City city) {
        return new City.city(
                city.getCityId(),
                city.getCityName(),
                city.getCountry());
    }
}
