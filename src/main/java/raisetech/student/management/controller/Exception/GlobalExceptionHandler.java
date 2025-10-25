package raisetech.student.management.controller.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import raisetech.student.management.exception.TestException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TestException.class) // TestExceptionを捕捉
    public ResponseEntity<String> handleTestException(TestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}