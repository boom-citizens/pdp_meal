package uz.d4uranbek.pdp_meal.service;


import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

import java.io.Serializable;
import java.util.List;

/**
 * @param <D> -> Dto
 * @param <K> -> class that defines the primary key for your pojo class
 * @param <C> -> Criteria (For Filtering Request)
 */
public interface GenericService<
        D extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends BaseService {

    List<D> getAll(C criteria);

    List<D> getAllById(C criteria, Long id);

    D get(K id);

    Long totalCount(C criteria);
}
