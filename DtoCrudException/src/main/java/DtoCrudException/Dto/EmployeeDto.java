package DtoCrudException.Dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {


    private Long id;


    @Size(min = 3, message = "name must contain 3 or more letters")
    @NotBlank(message = "Name cannot be empty")
    private  String name;


    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private  String email;

    @NotBlank(message = "Mobile number cannot be empty")
//    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String mobile;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 1, message = "Salary must be positive")
    private  double salary;



}
