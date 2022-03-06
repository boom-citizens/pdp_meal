package uz.d4uranbek.pdp_meal.exception;

import org.springframework.stereotype.Component;


public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
