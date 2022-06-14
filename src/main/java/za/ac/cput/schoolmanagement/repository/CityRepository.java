package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.schoolmanagement.domain.City;

public interface CityRepository extends JpaRepository<City, City.city>{

 //List <City> findByCityId( String CityId);

}
