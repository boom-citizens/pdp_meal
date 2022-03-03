package uz.d4uranbek.pdp_meal.validator.auth;

import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

import java.util.Objects;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@Component

public class AuthValidator extends AbstractValidator<AuthCreateDto, AuthUpdateDto, Long> {


    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(AuthCreateDto authCreateDto) throws ValidationException {
        if ((Objects.nonNull(authCreateDto.getPassword())
                && Objects.nonNull(authCreateDto.getUserName())
                && Objects.nonNull(authCreateDto.getPosition())))
            throw new ValidationException("User dont valid");
    }

    @Override
    public void validOnUpdate(AuthUpdateDto cd) throws ValidationException {
        if (Objects.isNull(cd))
            throw new ValidationException("User id not found");
    }
}
