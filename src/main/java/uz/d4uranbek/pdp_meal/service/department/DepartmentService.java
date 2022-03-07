package uz.d4uranbek.pdp_meal.service.department;

import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentCreateDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentUpdateDto;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.service.GenericCrudService;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/4/2022
 * @project : mealDeliver
 */

public interface DepartmentService extends GenericCrudService<Department, DepartmentDto,
        DepartmentCreateDto, DepartmentUpdateDto, GenericCriteria,Long> {
}
