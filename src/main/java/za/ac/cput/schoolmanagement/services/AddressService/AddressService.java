package za.ac.cput.schoolmanagement.services.AddressService;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.services.IService;

import java.util.Optional;

public interface AddressService extends IService <Address, String> {
    void deleteByStreetNumber(String streetNumber);
    Optional<Address> findByStreetNumber(String s);
}
