package uz.d4uranbek.pdp_meal.validator.order;

import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

import java.util.Objects;

/**
 * @author D4uranbek ср. 18:55. 02.03.2022
 */
@Component
public class OrderValidator extends AbstractValidator<OrderCreateDto, OrderUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrderCreateDto orderCreateDto) throws ValidationException {
        validDate(orderCreateDto.getDate());

        if (Objects.isNull(orderCreateDto.getUserId())) {
            throw new ValidationException("User should not be blank");
        }

        if (Objects.isNull(orderCreateDto.getMealId())) {
            throw new ValidationException("Meal should not be blank");
        }
    }

    @Override
    public void validOnUpdate(OrderUpdateDto orderUpdateDto) throws ValidationException {
        validDate(orderUpdateDto.getDate());

        if (Objects.isNull(orderUpdateDto.getUserId())) {
            throw new ValidationException("User should not be blank");
        }

        if (Objects.isNull(orderUpdateDto.getMealId())) {
            throw new ValidationException("Meal should not be blank");
        }
    }
}
