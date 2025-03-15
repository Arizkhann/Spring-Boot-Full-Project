package DtoCrudException.Exception;


import DtoCrudException.Dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {



    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundEXc(ResourceNotFoundExceptions er, WebRequest request){

        ErrorDetails errorDetails=new ErrorDetails(

                er.getMessage(),
                new Date(),
                request.getDescription(true)


        );


        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }

    //for Validation Errors

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }







    //for All other errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> allOtherEXc(Exception er, WebRequest request){

        ErrorDetails errorDetails=new ErrorDetails(

                er.getMessage(),
                new Date(),
                request.getDescription(true)


        );


        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
