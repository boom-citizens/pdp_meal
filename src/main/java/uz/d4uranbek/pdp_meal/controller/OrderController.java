package uz.d4uranbek.pdp_meal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.d4uranbek.pdp_meal.service.order.OrderServiceImpl;

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
}
