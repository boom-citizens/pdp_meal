package uz.d4uranbek.pdp_meal.response;

import lombok.Getter;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/5/2022
 * @project : mealDeliver
 */

@Getter

public class ResponceEntity<T>{
private final Integer status;
private final T data;

    public ResponceEntity(Integer status, T data) {
        this.status = status;
        this.data = data;
    }
}
