package uz.d4uranbek.pdp_meal.service;


import uz.d4uranbek.pdp_meal.mapper.Mapper;
import uz.d4uranbek.pdp_meal.repository.AbstractRepository;
import uz.d4uranbek.pdp_meal.validator.Validator;

/**
 * @param <R> repository
 * @param <M>
 * @param <V>
 */
public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper,
        V extends Validator> {
    protected final R repository;
    protected final M mapper;
    protected final V validator;


    protected AbstractService(R repository, M mapper, V validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }
}
