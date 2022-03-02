package uz.d4uranbek.pdp_meal.validator.meal;

import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

/**
 * @author D4uranbek ср. 18:13. 02.03.2022
 */
public class MealValidator extends AbstractValidator<MealCreateDto, MealUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(MealCreateDto mealCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(MealUpdateDto cd) throws ValidationException {

    }
}
