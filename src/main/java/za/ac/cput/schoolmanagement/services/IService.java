package za.ac.cput.schoolmanagement.services;

import za.ac.cput.schoolmanagement.domain.Student;

import java.util.Optional;

public interface IService<T, ID> {
    T save(T t);
    Optional<Student> read(ID id);
    void delete(T t);
}