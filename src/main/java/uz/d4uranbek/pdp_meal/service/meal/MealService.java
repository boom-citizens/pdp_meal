package uz.d4uranbek.pdp_meal.service.meal;

import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;
import uz.d4uranbek.pdp_meal.service.GenericCrudService;

/**
 * @author D4uranbek ср. 18:37. 02.03.2022
 */
public interface MealService extends GenericCrudService<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto,
        GenericCriteria,
        Long> {
}
