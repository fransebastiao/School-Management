package za.ac.cput.schoolmanagement.services.AddressService.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.AddressRepository;
import za.ac.cput.schoolmanagement.services.AddressService.AddressService;

import java.util.Optional;

@Service
public class AddressServiceImpl {

    /*private static AddressService SERVICE;
    private final AddressRepository repository;
    public AddressServiceImpl() {
        this.repository = new AddressRepository();
    }
    public static AddressService getService() {
        if (SERVICE == null) SERVICE = new AddressServiceImpl();
        return SERVICE;
    }
    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }
    @Override
    public Optional<Address> read(String s) {
        return this.repository.read(s);
    }
    @Override
    public void delete(Address address) {
        this.repository.delete(address);
    }*/
}
