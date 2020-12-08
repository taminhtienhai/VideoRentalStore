package iuh.software.controller;

import iuh.software.template.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Error> onRuntimeError(RuntimeException exception) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(Error.create(BAD_REQUEST, exception.getMessage()));
    }

}
