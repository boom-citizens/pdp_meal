package uz.d4uranbek.pdp_meal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author D4uranbek вт. 10:19. 01.03.2022
 */

@ControllerAdvice("uz.d4uranbek.pdp_meal")
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<AppError> invalidTokenExceptionHandler(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(AppError.builder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
