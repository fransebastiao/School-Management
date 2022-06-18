package za.ac.cput.schoolmanagement.services.cityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.repository.CityRepository;
import za.ac.cput.schoolmanagement.services.cityService.CityService;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    public City save(City city) {

        return this.repository.save(city);
    }

    public Optional<City> read(String id) {

        return this.repository.findById(id);
    }

    public void delete(City city) {

        this.repository.delete(city);
    }

    public List<City> findAll() {

        return this.repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<City> city = read(id);
        if (city.isPresent()) {
            delete(city.get());
        }

    }
    @Override
    public List<City> findCitiesByCountry(Country country) {
        try {
            return this.repository.findCitiesByCountry(country);
        }catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
}