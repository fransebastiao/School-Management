package za.ac.cput.schoolmanagement.services.cityService;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.services.IService;

import java.util.List;

public interface CityService extends IService <City, String > {

    void deleteById(String id);

    List<City> findAll();


    List<City> findCitiesByCountry(Country country);
}
