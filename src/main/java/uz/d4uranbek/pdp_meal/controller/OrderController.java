package uz.d4uranbek.pdp_meal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.service.order.OrderServiceImpl;

import java.util.List;

/**
 * @author D4uranbek ср. 19:10. 02.03.2022
 */

@RestController
@RequestMapping("/api/order")
@Api(
        value = "Api value for order-controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = {"order-api"}
)
public class OrderController extends AbstractController<OrderServiceImpl> {

    @Autowired
    protected OrderController(OrderServiceImpl service) {
        super(service);
    }

    @GetMapping("/list")
    public List<OrderDto> orders() {
        return service.getAll(new GenericCriteria());
    }

    @GetMapping("/id/{id}")
    public OrderDto order(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/date/{date}")
    public List<OrderDto> orderByDate(@PathVariable String date) {
        return service.getAllByDate(date);
    }

    @GetMapping("/meal/{id}")
    public List<OrderDto> orderByMealId(@PathVariable Long mealId) {
        return service.getAllByMealId(mealId);
    }

    @GetMapping("/user/{id}")
    public List<OrderDto> orderByUserId(@PathVariable Long userId) {
        return service.getAllByUserId(userId);
    }

    @PostMapping("/create")
    public Long create(@RequestBody OrderCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Void update(@RequestBody OrderUpdateDto dto) {
        return service.update(dto);
    }

    @GetMapping("/today")
    public List<OrderDto> ordersOfToday() {
        return service.ordersOfToday();
    }
}
