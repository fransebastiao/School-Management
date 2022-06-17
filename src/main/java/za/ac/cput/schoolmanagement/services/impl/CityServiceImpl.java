package za.ac.cput.schoolmanagement.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.services.CityService;
import za.ac.cput.schoolmanagement.repository.CityRepository;

import java.util.List;
import java.util.Optional;



@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired public CityServiceImpl(CityRepository repository){
        this.repository = repository;
    }



    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<City> city = read(id);
        if (city.isPresent()) {
            delete(city.get());
        }
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String s) {

        return this.repository.findById(s);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);

    }
    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }

}
