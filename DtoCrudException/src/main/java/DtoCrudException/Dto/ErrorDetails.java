package DtoCrudException.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor

public class ErrorDetails {

    //properties/instance variable/

    private String message;
    private Date date;
    private String description;



}
