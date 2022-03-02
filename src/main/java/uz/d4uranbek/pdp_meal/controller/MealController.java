package uz.d4uranbek.pdp_meal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.d4uranbek.pdp_meal.service.meal.MealServiceImpl;

/**
 * @author D4uranbek ср. 18:58. 02.03.2022
 */
@RestController
@RequestMapping("/api/meal")
@Api(
        value = "Api value for meal-controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = {"meal-api"}
)
public class MealController extends AbstractController<MealServiceImpl> {

    @Autowired
    protected MealController(MealServiceImpl service) {
        super(service);
    }


}
