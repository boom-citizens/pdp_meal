package uz.d4uranbek.pdp_meal.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.service.meal.MealServiceImpl;

import java.util.List;

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

    @GetMapping("/list")
    public List<MealDto> meals() {
        return service.getAll(new GenericCriteria());
    }

    @GetMapping("/id/{id}")
    public MealDto meal(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/date/{date}")
    public List<MealDto> mealByDate(@PathVariable String date) {
        return service.getAllByDate(date);
    }

    @PostMapping("/create")
    public Long create(@RequestBody MealCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Void update(@RequestBody MealUpdateDto dto) {
        return service.update(dto);
    }

}
