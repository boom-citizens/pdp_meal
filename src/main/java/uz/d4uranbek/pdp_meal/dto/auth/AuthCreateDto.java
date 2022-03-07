package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.Dto;

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
    private String language;
    private String role;
    private String position;
    private String status;
    private String department;
    private Long chatId;
}
