package za.ac.cput.schoolmanagement.repository;
/*
School_Management
StudentAddress Repository Layer JPA
Author: Edvalter da Costa Jamba (220446571)
Date: 11 June 2022
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, String> {
}
