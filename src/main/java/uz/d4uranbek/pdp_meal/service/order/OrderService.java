package uz.d4uranbek.pdp_meal.service.order;

import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.entity.order.Order;
import uz.d4uranbek.pdp_meal.service.GenericCrudService;

/**
 * @author D4uranbek ср. 18:53. 02.03.2022
 */
public interface OrderService extends GenericCrudService<
        Order,
        OrderDto,
        OrderCreateDto,
        OrderUpdateDto,
        GenericCriteria,
        Long> {
}
