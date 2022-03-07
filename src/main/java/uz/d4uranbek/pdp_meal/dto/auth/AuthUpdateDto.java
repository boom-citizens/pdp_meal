package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */

@Getter
@Setter

public class AuthUpdateDto extends GenericDto {
    private String userName;
    private String phone;
    private String fullName;



    public AuthUpdateDto(Long id, String userName, String phone,
                         String fullName) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.fullName = fullName;

    }
}
