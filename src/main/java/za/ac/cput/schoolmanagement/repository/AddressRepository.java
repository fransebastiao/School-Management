package za.ac.cput.schoolmanagement.repository;

/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
}
