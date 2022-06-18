package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.api.CityAPI;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.services.cityService.CityService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CityController {

    private final CityService cityService;
    private final CityAPI CityAPI;


    @Autowired
    public CityController(CityService cityService, CityAPI cityAPI) {

        this.cityService = cityService;
        this.CityAPI = cityAPI;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        log.info("save request: {}", city);
        City save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        City city = this.cityService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete request{}", id);
        this.cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List<City> cityList = this.cityService.findAll();
        return ResponseEntity.ok(cityList);
    }

    // Question 7:
    @GetMapping("read-city-by-country-id/{countryId}")
    public ResponseEntity<List<String>> findCitiesByCountry(@PathVariable String countryId) {
        log.info("get cities in country: {}", countryId);
        List<String> cityNameList = this.CityAPI.findCitiesByCountry(countryId);
        System.out.println(cityNameList);
        return ResponseEntity.ok(cityNameList);
    }
}