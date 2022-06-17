package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.services.CityService;
import java.util.List;



@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }
    @PostMapping("save")
    public ResponseEntity<City> save(@RequestBody City city) {
        log.info("Save request: {}", city);
        City validatedCity;
        try {

            validatedCity = CityFactory.build(city.getCityId(),
                    city.getCityName(),
                    city.getCountry());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City save = cityService.save(validatedCity);
        return ResponseEntity.ok(save);

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id){
        log.info("Read request: {}", id);
        City city = this.cityService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll(){
        List<City> cityList = this.cityService.findAll();
        return ResponseEntity.ok(cityList);
    }

}
