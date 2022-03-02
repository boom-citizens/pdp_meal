package uz.d4uranbek.pdp_meal.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Getter
@AllArgsConstructor

public enum Status {
    NOT_ACTIVE("Not active"),
    ACTIVE("Active"),
    BLOCK("Block"),
    UNBLOCK("UnBlock");
    private final String code;
}

