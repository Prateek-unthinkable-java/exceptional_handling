package com.example.exceptional_handling.handlers;

import com.example.exceptional_handling.exceptions.CustomerAlreadyExistsException;
import com.example.exceptional_handling.exceptions.EmptyListException;
import com.example.exceptional_handling.exceptions.NoSuchCustomerExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Object> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException){
        return new ResponseEntity<>("Customer already exists with this id.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchCustomerExistsException.class)
    public ResponseEntity<Object> handleNoSuchCustomerExistsException(NoSuchCustomerExistsException noSuchCustomerExistsException){
        return new ResponseEntity<>("There is no customer with this id.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<Object> handleEmptyListException(EmptyListException emptyListException){
        return new ResponseEntity<>("There is no customer in list, Please add some customers to fetch them.", HttpStatus.CONFLICT);
    }
}
