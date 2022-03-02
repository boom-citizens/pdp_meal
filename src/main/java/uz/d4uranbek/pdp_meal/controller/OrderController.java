package uz.d4uranbek.pdp_meal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
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
    public List<OrderDto> meals() {
        return service.getAll(new GenericCriteria());
    }

    @GetMapping("/{id}")
    public OrderDto meal(@PathVariable Long id) {
        return service.get(id);
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
}
