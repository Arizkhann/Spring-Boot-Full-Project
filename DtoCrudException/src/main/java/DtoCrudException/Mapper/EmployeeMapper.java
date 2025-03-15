package DtoCrudException.Mapper;

import DtoCrudException.Dto.EmployeeDto;
import DtoCrudException.Entity.Employee;

public class EmployeeMapper {


    public static EmployeeDto mapToEMployeeDto(Employee employee){


     return new EmployeeDto(

             employee.getId(),
             employee.getName(),
             employee.getEmail(),
             employee.getMobile(),
             employee.getSalary()

     )   ;
    }


    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getMobile(),
                employeeDto.getSalary()

        );
    }



}
