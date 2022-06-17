package za.ac.cput.schoolmanagement.services.AddressService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.AddressRepository;
import za.ac.cput.schoolmanagement.services.AddressService.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private static List<Address> addressList;
    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {this.repository = repository;}

    @Override
    public Address save(Address address) {return this.repository.save(address);}

    @Override
    public Optional<Address> read(String s) {return this.repository.findByStreetNumber(s);}

    @Override
    public void delete(Address address) {this.repository.delete(address);}

    @Override
    public List<Address> findAll() {return null;}                   //Do not need to return all addresses

    @Override
    public void deleteByStreetNumber(String streetNumber) {
        repository.deleteByStreetNumber(streetNumber);
        Optional<Address> address = read(streetNumber);
        if (address.isPresent()) {
            delete(address.get());
        }
    }

    @Override
    public Optional<Address> findByStreetNumber(String streetNumber) {
        return this.addressList.stream().filter(g -> g.getStreetNumber().equalsIgnoreCase(streetNumber))
                .findFirst();
    }

}
