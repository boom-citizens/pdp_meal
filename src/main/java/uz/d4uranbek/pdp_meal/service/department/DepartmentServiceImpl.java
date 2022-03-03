package uz.d4uranbek.pdp_meal.service.department;

import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentCreateDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentDto;
import uz.d4uranbek.pdp_meal.dto.department.DepartmentUpdateDto;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.mapper.department.DepartmentMapper;
import uz.d4uranbek.pdp_meal.repository.department.DepartmentRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.department.DepartmentValidator;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */
@Service
public class DepartmentServiceImpl extends AbstractService<DepartmentRepository, DepartmentMapper, DepartmentValidator> implements DepartmentService {

    protected DepartmentServiceImpl(DepartmentRepository repository, DepartmentMapper mapper, DepartmentValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(DepartmentCreateDto createDto) {
        Department department = mapper.fromCreateDto(createDto);
        return repository.save(department).getId();
    }

    @Override
    public Void delete(Long id) {
        //validator.validOnCreate();
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(DepartmentUpdateDto updateDto) {
//        validator.validOnUpdate(updateDto);
        Department department = mapper.fromUpdateDto(updateDto);
        repository.save(department);
        return null;
    }

    @Override
    public List<DepartmentDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<DepartmentDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public DepartmentDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("");
        }));
    }


    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
