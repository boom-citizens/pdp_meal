package uz.d4uranbek.pdp_meal.validator.department;

import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentCreateDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/4/2022
 * @project : mealDeliver
 */
@Component
public class DepartmentValidator extends AbstractValidator<DepartmentCreateDto, DepartmentUpdateDto,Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(DepartmentCreateDto departmentCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(DepartmentUpdateDto cd) throws ValidationException {

    }
}
