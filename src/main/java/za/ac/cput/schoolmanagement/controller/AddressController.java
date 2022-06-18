package za.ac.cput.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.services.AddressService.AddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/address/")
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public ResponseEntity<Address> save(@RequestBody Address address){
        log.info("Save request: {}", address);
        Address addressObj;
        try{
            addressObj = AddressFactory.build(address.getUnitNumber(), address.getComplexName(),
                    address.getStreetNumber(), address.getStreetName(), address.getPostalCode(),
                    address.getCity());
        }
        catch (IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, iae.getMessage());
        }
        Address save = addressService.save(addressObj);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{streetNumber}")
    public ResponseEntity<Address> read(@PathVariable String streetNumber) {
        //Used to call error messages
        log.info("Read request: {}", streetNumber);
        Address address = this.addressService.read(streetNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("delete/{streetNumber}")
    public ResponseEntity<Void> delete(@PathVariable String streetNumber) {
        log.info("Read request: {}", streetNumber);
        this.addressService.deleteByStreetNumber(streetNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Address>> findAll() {
        List<Address> addressList = this.addressService.findAll();
        return ResponseEntity.ok(addressList);
    }
}
