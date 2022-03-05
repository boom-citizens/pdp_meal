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

public class Data<T> {
    private Integer totalCount;
    private final T body;

    public Data(T body) {
        this.body = body;
    }


    public Data(Integer totalCount, T body) {
        this.totalCount = totalCount;
        this.body = body;
    }
}
