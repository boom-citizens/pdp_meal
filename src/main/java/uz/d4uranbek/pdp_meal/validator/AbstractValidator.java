package uz.d4uranbek.pdp_meal.validator;


import uz.d4uranbek.pdp_meal.dto.Dto;
import uz.d4uranbek.pdp_meal.dto.GenericDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractValidator<
        CD extends Dto,
        UD extends GenericDto,
        K extends Serializable> implements Validator {

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


    public LocalDate validDate(String date) {
        if (!date.matches(DATE_REGEX)) {
            throw new ValidationException("Invalid date format");
        }
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
