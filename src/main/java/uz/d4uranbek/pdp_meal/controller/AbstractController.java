package uz.d4uranbek.pdp_meal.controller;

import uz.d4uranbek.pdp_meal.service.BaseService;

public abstract class AbstractController<S extends BaseService> {
    protected final S service;

    protected AbstractController(S service) {
        this.service = service;
    }
}
