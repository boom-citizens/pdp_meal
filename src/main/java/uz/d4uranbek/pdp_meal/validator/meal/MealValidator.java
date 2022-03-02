package uz.d4uranbek.pdp_meal.validator.meal;

import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

import java.util.Objects;

/**
 * @author D4uranbek ср. 18:13. 02.03.2022
 */
@Component
public class MealValidator extends AbstractValidator<MealCreateDto, MealUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(MealCreateDto mealCreateDto) throws ValidationException {
        if (!mealCreateDto.getDate().matches(DATE_REGEX)) {
            throw new ValidationException("Invalid date format");
        }

        if (Objects.isNull(mealCreateDto.getName()) || "".equals(mealCreateDto.getName())) {
            throw new ValidationException("Name should not be blank");
        }
    }

    @Override
    public void validOnUpdate(MealUpdateDto mealUpdateDto) throws ValidationException {
        if (!mealUpdateDto.getDate().matches(DATE_REGEX)) {
            throw new ValidationException("Invalid date format");
        }

        if (Objects.isNull(mealUpdateDto.getName()) || "".equals(mealUpdateDto.getName())) {
            throw new ValidationException("Name should not be blank");
        }
    }
}
