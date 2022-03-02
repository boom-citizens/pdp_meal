package uz.d4uranbek.pdp_meal.service.meal;

import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.meal.MealCreateDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealDto;
import uz.d4uranbek.pdp_meal.dto.meal.MealUpdateDto;
import uz.d4uranbek.pdp_meal.mapper.meal.MealMapper;
import uz.d4uranbek.pdp_meal.repository.meal.MealRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.meal.MealValidator;

import java.io.IOException;
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

    protected MealServiceImpl(MealRepository repository, MealMapper mapper, MealValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(MealCreateDto createDto) throws IOException {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(MealUpdateDto updateDto) throws IOException {
        return null;
    }

    @Override
    public List<MealDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<MealDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public MealDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
