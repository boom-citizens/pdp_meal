package uz.d4uranbek.pdp_meal.exception;


import uz.d4uranbek.pdp_meal.enums.http.HttpStatus;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

public class InvalidTokenException extends RuntimeException {
    private  final HttpStatus status;

    public InvalidTokenException(String message){
this(message,HttpStatus.INVALID_TOKEN);
    }

    public InvalidTokenException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }
}
