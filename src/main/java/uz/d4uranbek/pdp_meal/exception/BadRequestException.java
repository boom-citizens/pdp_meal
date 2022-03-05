package uz.d4uranbek.pdp_meal.exception;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
