package DtoCrudException.Repository;

import DtoCrudException.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

   Optional<Employee> getByName(String name);

   Optional<Employee> searchByNameAndEmail(String name,String email);

}
