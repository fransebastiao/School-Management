package za.ac.cput.schoolmanagement.services.StudentService;
/*
 School_Management
 StudentAddressServiceImpl
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.repository.StudentAddressRepository;


import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddressService{

    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteUsingId(String id) {
        repository.deleteById(id);
        Optional<StudentAddress> studentaddress = read(id);
        if (studentaddress.isPresent()) {
            delete(studentaddress.get());
        }

    }
}
