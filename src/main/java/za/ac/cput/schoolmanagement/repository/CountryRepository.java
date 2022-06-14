package za.ac.cput.schoolmanagement.repository;
/*
CountryRepository.java
This is an interface for Country Repository
Siphelele Nyathi 218334028
10.06.2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
