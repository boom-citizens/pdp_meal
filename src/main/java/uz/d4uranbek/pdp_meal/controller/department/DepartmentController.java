package uz.d4uranbek.pdp_meal.controller.department;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.pdp_meal.controller.AbstractController;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentCreateDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentUpdateDto;
import uz.d4uranbek.pdp_meal.service.department.DepartmentService;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@RestController
@RequestMapping("/api/department/*")
@Api(
        value = "Api value for meal-controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = {"department-api"}
)

public class DepartmentController extends AbstractController<DepartmentService> {


    protected DepartmentController(DepartmentService service) {
        super(service);
    }

    @PostMapping(value = "create")
    public Long create(@ModelAttribute DepartmentCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping("{id}")
    public DepartmentDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public List<DepartmentDto> departments() {
        return service.getAll(new GenericCriteria());
    }

    @DeleteMapping(value = "delete/{id}")
    public Void delete(@PathVariable Long id) {
        service.delete(id);
        return null;
    }

    @PutMapping(value = "update")
    public Void update(@ModelAttribute DepartmentUpdateDto dto) {
        service.update(dto);
        return null;
    }
}
