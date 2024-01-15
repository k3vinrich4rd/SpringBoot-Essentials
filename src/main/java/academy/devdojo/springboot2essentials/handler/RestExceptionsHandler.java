package academy.devdojo.springboot2essentials.handler;

import academy.devdojo.springboot2essentials.exception.NotFoundException;
import academy.devdojo.springboot2essentials.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionsHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundRequestException(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                NotFoundExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception, Check the Documentation")
                        .details(notFoundException.getMessage())
                        .developMessage(notFoundException.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);


    }
}
