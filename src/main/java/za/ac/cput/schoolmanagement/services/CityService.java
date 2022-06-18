package za.ac.cput.schoolmanagement.services;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.services.IService;

import java.util.List;

public interface CityService extends IService <City, String > {

    void deleteById(String id);

    List<City> findAll();



}
