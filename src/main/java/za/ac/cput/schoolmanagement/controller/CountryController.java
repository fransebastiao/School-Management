package za.ac.cput.schoolmanagement.controller;
/*
CountryController.java
This is a controller class for Country
Siphelele Nyathi 218334028
17.06.2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.services.countryService.CountryService;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("school-management/country/")
@Slf4j
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        log.info("Save request: {}", country );
        Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Country country = this.countryService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }
    @DeleteMapping("delete/{country}")
    public ResponseEntity<Void> delete(@PathVariable String country) {
        log.info("Delete request{}", country);
        this.countryService.deleteById(country);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countryList = this.countryService.findAll();
        return ResponseEntity.ok(countryList);
    }

}