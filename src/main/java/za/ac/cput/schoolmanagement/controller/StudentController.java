package za.ac.cput.schoolmanagement.controller;
/*
 School_Management
 StudentController
 Author: Edvalter da Costa Jamba (220446571)
 Date: 17 June 2022
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.services.StudentService.StudentService;

import javax.validation.Valid;


@RestController
@RequestMapping("school-management/Student/")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("save")
    public ResponseEntity<Student> save(@RequestBody @Valid Student student)
    {
        Student saved=this.service.save(student);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.service.deleteUsingId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id){
        Student student = this.service.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

}
