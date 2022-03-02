package uz.d4uranbek.pdp_meal.service.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;
import uz.d4uranbek.pdp_meal.mapper.meal.MealMapper;
import uz.d4uranbek.pdp_meal.repository.meal.MealRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.meal.MealValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author D4uranbek ср. 18:33. 02.03.2022
 */
@Service
public class MealServiceImpl extends AbstractService<
        MealRepository,
        MealMapper,
        MealValidator>
        implements MealService {

    @Autowired
    protected MealServiceImpl(MealRepository repository, MealMapper mapper, MealValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(MealCreateDto createDto) {
        validator.validOnCreate(createDto);
        Meal meal = mapper.fromCreateDto(createDto);
        meal.setDate(LocalDate.parse(createDto.getDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        return repository.save(meal).getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(MealUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Meal meal = repository
                .findById(updateDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found"));
        mapper.fromUpdateDto(updateDto, meal);
//        meal.setDate(LocalDate.parse(updateDto.getDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        repository.save(meal);

        return null;
    }

    @Override
    public List<MealDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<MealDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public MealDto get(Long id) {
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found")));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
