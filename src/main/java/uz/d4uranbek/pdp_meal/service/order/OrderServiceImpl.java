package uz.d4uranbek.pdp_meal.service.order;


import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.order.OrderCreateDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderDto;
import uz.d4uranbek.pdp_meal.dto.order.OrderUpdateDto;
import uz.d4uranbek.pdp_meal.mapper.order.OrderMapper;
import uz.d4uranbek.pdp_meal.repository.order.OrderRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.OrderValidator;

import java.io.IOException;
import java.util.List;

/**
 * @author D4uranbek ср. 18:53. 02.03.2022
 */
@Service
public class OrderServiceImpl extends AbstractService<
        OrderRepository,
        OrderMapper,
        OrderValidator>
        implements OrderService {

    protected OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OrderValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(OrderCreateDto createDto) throws IOException {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(OrderUpdateDto updateDto) throws IOException {
        return null;
    }

    @Override
    public List<OrderDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<OrderDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public OrderDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
