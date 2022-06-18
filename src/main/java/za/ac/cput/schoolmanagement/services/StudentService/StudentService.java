/*
 School_Management
 StudentService
 Author: Edvalter da Costa Jamba (220446571)
 Date: 16 June 2022
*/
package za.ac.cput.schoolmanagement.services.StudentService;

import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.services.IService;

public interface StudentService extends IService<Student, String> {
    void deleteById(String id);
}