/* Entity: EMPLOYEEADDRESS
 * EmployeeAddressController
 * SCHOOL-MANAGEMENT
 *Author: TSHEPANG MOLEFE 216217717
 *  Date: 16-06-2022
 */

package za.ac.cput.schoolmanagement.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;
import za.ac.cput.schoolmanagement.services.IEmployeeAddressService;
import java.util.List;

@RestController
@RequestMapping("School-Management/ EmployeAddress/")
@Slf4j


public class EmployeeAddressController
{

        private final IEmployeeAddressService employeeAddressService;

        @Autowired
        public EmployeeAddressController(IEmployeeAddressService employeeAddressService)
        {
            this.employeeAddressService = employeeAddressService;
        }

        @PostMapping("save")
        public ResponseEntity<EmployeeAddress> save (@RequestBody EmployeeAddress employeeAddress)
        {
            log.info("Save request: {}", employeeAddress);
            EmployeeAddress validatedEmployeeAddress;
            try
            {
                validatedEmployeeAddress = EmployeeAddressFactory.build(employeeAddress.getStaffId(),
                        employeeAddress.getAddress());
            }catch
                  (IllegalArgumentException e){
                log.info("Save request error: {}", e.getMessage());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            EmployeeAddress save = employeeAddressService.save(employeeAddress);
            return ResponseEntity.ok(save);
        }

        @DeleteMapping("delete/{id}")
        public ResponseEntity <Void> delete(@PathVariable String id )
        {
            log.info("Read request: {}", id);
             this.employeeAddressService.deleteById(id);
            return ResponseEntity.noContent().build();
    }


        @GetMapping("read/{id}/{address}")
        public ResponseEntity<EmployeeAddress> read (@PathVariable String id)
        {
            log.info("Read request: {}", id);
            EmployeeAddress employeeAddress = this.employeeAddressService.read(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return ResponseEntity.ok(employeeAddress);
        }



        @GetMapping("all")
        public ResponseEntity<List<EmployeeAddress>> findAll()
        {
            List<EmployeeAddress> EmployeeAddress = this.employeeAddressService.findAll();
            return ResponseEntity.ok(EmployeeAddress);
        }


}
