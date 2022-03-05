package uz.d4uranbek.pdp_meal.controller.auth;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.pdp_meal.controller.AbstractController;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthRequestDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.service.auth.AuthServiceImpl;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@RestController
@RequestMapping("/api/auth/*")
@Api(
        value = "Api value for meal-controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = {"meal-api"}
)

public class AuthController extends AbstractController<AuthServiceImpl> {


    @Autowired
    public AuthController(AuthServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody AuthRequestDto dto) {
        return service.login(dto);
    }

    @PostMapping("create")
    public Long create(@RequestBody AuthCreateDto dto){
        return service.create(dto);
    }

    @DeleteMapping("{id}")
    public Void delete(Long id){
        return service.delete(id);
    }

    @GetMapping("{id}")
    public AuthDto get(Long id){
        return service.get(id);
    }

    @PutMapping("update")
    public Void update(@RequestBody AuthUpdateDto dto){
    return     service.update(dto);
    }

    @GetMapping("list")
    public List<AuthDto> getAll(){
        return service.getAll(new GenericCriteria());
    }




}
