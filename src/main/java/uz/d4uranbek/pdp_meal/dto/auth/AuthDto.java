package uz.d4uranbek.pdp_meal.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.Dto;
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
@NoArgsConstructor
@AllArgsConstructor

public class AuthDto extends GenericDto {
    private String userName;
    private String phone;
    private String password;
    private String fullName;
    private Language language;
    private Role role;
    private Long chatId;
    private Positions position;
    private Status status;

    public AuthDto(Long id, String userName, String phone,
                   String password, String fullName,
                   Language language, Role role, Long chatId,
                   Positions position, Status status) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.language = language;
        this.role = role;
        this.chatId = chatId;
        this.position = position;
        this.status = status;
    }
}
