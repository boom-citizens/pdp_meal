package uz.d4uranbek.pdp_meal.validator;


import uz.d4uranbek.pdp_meal.dto.Dto;
import uz.d4uranbek.pdp_meal.dto.GenericDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;

import java.io.Serializable;

public abstract class AbstractValidator<
        CD extends Dto,
        UD extends GenericDto,
        K extends Serializable> implements Validator {

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


}
