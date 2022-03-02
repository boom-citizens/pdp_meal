package uz.d4uranbek.pdp_meal.service;

import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.Dto;
import uz.d4uranbek.pdp_meal.dto.GenericDto;
import uz.d4uranbek.pdp_meal.entity.BaseEntity;

import java.io.IOException;
import java.io.Serializable;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 * @param <K>  -> class that defines the primary key for your pojo class
 * @param <C>  -> Criteria (For Filtering Request)
 */
public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends GenericService<D, C, K> {

    K create(CD createDto) throws IOException;

    Void delete(K id);

    Void update(UD updateDto) throws IOException;

}
