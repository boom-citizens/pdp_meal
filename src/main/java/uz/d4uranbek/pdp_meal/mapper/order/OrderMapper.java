package uz.d4uranbek.pdp_meal.mapper.order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;
import uz.d4uranbek.pdp_meal.entity.order.Order;
import uz.d4uranbek.pdp_meal.mapper.BaseMapper;

import java.util.List;

/**
 * @author D4uranbek ср. 18:34. 02.03.2022
 */
@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<
        Order,
        OrderDto,
        OrderCreateDto,
        OrderUpdateDto> {

    @Override
    OrderDto toDto(Order order);

    @Override
    List<OrderDto> toDto(List<Order> e);

    @Override
    Order fromCreateDto(OrderCreateDto orderCreateDto);

    @Override
    Order fromUpdateDto(OrderUpdateDto orderUpdateDto);

    //Meal fromUpdateDto(OrderUpdateDto dto, @MappingTarget Order order);
}
