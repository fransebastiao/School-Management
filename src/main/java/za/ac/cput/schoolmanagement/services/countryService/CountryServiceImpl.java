package za.ac.cput.schoolmanagement.services.countryService;
/*
CountryService.java
This is an implementation for Country Services
Siphelele Nyathi 218334028
15.06.2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.repository.CountryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Autowired public CountryServiceImpl(CountryRepository repository){
        this.repository = repository;
    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public void deleteById(String id) {
        Optional<Country> country = read(id);
        if(country.isPresent())
            deleteById(id);
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }
}
