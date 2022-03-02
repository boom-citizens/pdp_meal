package uz.d4uranbek.pdp_meal.mapper.meal;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;
import uz.d4uranbek.pdp_meal.mapper.BaseMapper;

import java.util.List;

/**
 * @author D4uranbek ср. 18:34. 02.03.2022
 */
@Component
@Mapper(componentModel = "spring")
public interface MealMapper extends BaseMapper<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto> {

    @Override
    MealDto toDto(Meal meal);

    @Override
    List<MealDto> toDto(List<Meal> e);

    @Override
    Meal fromCreateDto(MealCreateDto mealCreateDto);

    @Override
    Meal fromUpdateDto(MealUpdateDto mealUpdateDto);
}
