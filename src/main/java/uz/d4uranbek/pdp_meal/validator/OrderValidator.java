package uz.d4uranbek.pdp_meal.validator;

import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.exception.ValidationException;

/**
 * @author D4uranbek ср. 18:22. 02.03.2022
 */
public class OrderValidator extends AbstractValidator<OrderCreateDto, OrderUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrderCreateDto orderCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrderUpdateDto cd) throws ValidationException {

    }
}
