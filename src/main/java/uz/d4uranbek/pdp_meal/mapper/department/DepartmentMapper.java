package uz.d4uranbek.pdp_meal.mapper.department;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentCreateDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentUpdateDto;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.mapper.BaseMapper;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

@Component
@Mapper(componentModel = "spring")

public interface DepartmentMapper extends BaseMapper<Department, DepartmentDto, DepartmentCreateDto, DepartmentUpdateDto> {

}
