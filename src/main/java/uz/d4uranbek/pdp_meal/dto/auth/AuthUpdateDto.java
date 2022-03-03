package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;

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
    private Language language;


    public AuthUpdateDto(Long id, String userName, String phone,
                         String fullName, Language language) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.fullName = fullName;
        this.language = language;
    }
}
