package uz.d4uranbek.pdp_meal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.d4uranbek.pdp_meal.service.meal.MealService;

/**
 * @author D4uranbek ср. 18:58. 02.03.2022
 */
@Controller
@RequestMapping("/meal/*")
public class MealController extends AbstractController<MealService> {

    @Autowired
    protected MealController(MealService service) {
        super(service);
    }
}
