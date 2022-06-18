package za.ac.cput.schoolmanagement.controller;
/*
 School_Management
 StudentAddressComtroller
 Author: Edvalter da Costa Jamba (220446571)
 Date: 17 June 2022
*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.services.StudentService.StudentAddressService;


import javax.validation.Valid;


@RestController
@RequestMapping("school-management/Student/")
public class StudentAddressComtroller {

    private final StudentAddressService service;

    public StudentAddressComtroller(StudentAddressService service) {
        this.service = service;
    }

    @RequestMapping("save")
    public ResponseEntity<StudentAddress> save(@RequestBody @Valid StudentAddress student)
    {
        StudentAddress saved=this.service.save(student);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.service.deleteUsingId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id){
        StudentAddress student = this.service.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }


}
