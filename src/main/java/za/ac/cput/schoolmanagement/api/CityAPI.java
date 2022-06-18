/* CityAPI.java
Author: Sharfaa Sedick Anthony 220041571
Date: 17 June 2022 */
package za.ac.cput.schoolmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.services.cityService.CityService;
import za.ac.cput.schoolmanagement.services.countryService.CountryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Component
public class CityAPI {

    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public CityAPI(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    //Question 7:
    public List<String> findCitiesByCountry(String countryId) {
        try {
            Country country = this.countryService.read(countryId).get();
            List<City> foundCities = this.cityService.findCitiesByCountry(country);
            if(foundCities != null && foundCities.size() > 0){
                List<String> cityNameList = new ArrayList<>();
                foundCities.forEach(city -> cityNameList.add(city.getName()));
                Collections.sort(cityNameList);
                return cityNameList;
            }
        }catch (NoSuchElementException e){
            return null;
        }
        return null;
    }
}