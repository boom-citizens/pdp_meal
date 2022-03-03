package uz.d4uranbek.pdp_meal.service.order;


import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.entity.order.Order;
import uz.d4uranbek.pdp_meal.mapper.order.OrderMapper;
import uz.d4uranbek.pdp_meal.repository.auth.AuthRepository;
import uz.d4uranbek.pdp_meal.repository.meal.MealRepository;
import uz.d4uranbek.pdp_meal.repository.order.OrderRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.order.OrderValidator;

import java.time.LocalDate;
import java.util.List;

/**
 * @author D4uranbek ср. 18:53. 02.03.2022
 */
@Service
public class OrderServiceImpl extends AbstractService<OrderRepository, OrderMapper, OrderValidator> implements OrderService {

    private final MealRepository mealRepository;
    private final AuthRepository userRepository;

    protected OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OrderValidator validator, MealRepository mealRepository, AuthRepository userRepository) {
        super(repository, mapper, validator);
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Long create(OrderCreateDto createDto) {
        validator.validOnCreate(createDto);
        Order order = mapper.fromCreateDto(createDto);
        order.setUser(userRepository.getById(createDto.getUserId()));
        order.setMeal(mealRepository.getById(createDto.getMealId()));
        order.setDate(LocalDate.parse(createDto.getDate()));
//        order.setDate(LocalDate.parse(createDto.getDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        return repository.save(order).getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrderUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Order order = repository.findById(updateDto.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        mapper.fromUpdateDto(updateDto, order);
        repository.save(order);

        return null;
    }

    @Override
    public List<OrderDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<OrderDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public OrderDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found")));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    public List<OrderDto> getAllByDate(String date) {
        LocalDate localDate = validator.validDate(date);
        return mapper.toDto(repository.findAllByDate(localDate));
    }

    public List<OrderDto> getAllByMealId(Long mealId) {
        return mapper.toDto(repository.findAllByMealId(mealId));
    }

    public List<OrderDto> getAllByUserId(Long userId) {
        return mapper.toDto(repository.findAllByUserId(userId));
    }

    public List<OrderDto> ordersOfToday() {
        return mapper.toDto(repository.findAllByDate(LocalDate.now()));
    }

    public List<Long> notOrderedUsersList() {
        return repository.notOrderedUsersList();
    }
}
