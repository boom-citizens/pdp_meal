package uz.d4uranbek.pdp_meal.enums.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

@Getter
@RequiredArgsConstructor
public enum HttpStatus {
    INVALID_TOKEN(440, "invalid token"),
    BAD_REQUEST(400, "bad request");

    private final Integer code;
    private final String message;

}
