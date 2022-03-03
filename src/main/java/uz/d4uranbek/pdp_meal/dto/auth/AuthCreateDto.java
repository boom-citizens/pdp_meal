package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.Dto;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthCreateDto implements Dto {
    private String userName;
    private String phone;
    private String password;
    private String fullName;
    private String  language;
    private String role;
    private String position;
    private String status;
}
