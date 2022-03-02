package uz.d4uranbek.pdp_meal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.d4uranbek.pdp_meal.service.meal.MealServiceImpl;

/**
 * @author D4uranbek ср. 18:58. 02.03.2022
 */
@RestController
@RequestMapping("/api/meal")
public class MealController extends AbstractController<MealServiceImpl> {

    @Autowired
    protected MealController(MealServiceImpl service) {
        super(service);
    }


}