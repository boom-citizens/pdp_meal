package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

    private String userName;
    private String password;

}
