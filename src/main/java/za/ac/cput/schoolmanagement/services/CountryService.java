package za.ac.cput.schoolmanagement.services;

import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;
import java.util.Optional;

/*
CountryService.java
This is an interface for Country Services
Siphelele Nyathi 218334028
15.06.2022
 */
public interface CountryService extends IService<Country, String>{

    List<Country> findAll();
    void deleteById(String id);
}
