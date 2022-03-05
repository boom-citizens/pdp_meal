package uz.d4uranbek.pdp_meal.validator.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;

import uz.d4uranbek.pdp_meal.exception.ValidationException;
import uz.d4uranbek.pdp_meal.repository.department.DepartmentRepository;
import uz.d4uranbek.pdp_meal.repository.language.LanguageRepository;
import uz.d4uranbek.pdp_meal.repository.position.PositionRepository;
import uz.d4uranbek.pdp_meal.repository.role.RoleRepository;
import uz.d4uranbek.pdp_meal.validator.AbstractValidator;

import java.util.Objects;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@Component

public class AuthValidator extends AbstractValidator<AuthCreateDto, AuthUpdateDto, Long> {

    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;
    private final ValidationException validationException;



    public AuthValidator(RoleRepository roleRepository, LanguageRepository languageRepository,
                         PositionRepository positionRepository, DepartmentRepository departmentRepository,
                         ValidationException validationException) {
        this.roleRepository = roleRepository;
        this.languageRepository = languageRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
        this.validationException = validationException;
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(AuthCreateDto authCreateDto) throws ValidationException {
        if (!(Objects.nonNull(authCreateDto.getPassword())
                && Objects.nonNull(authCreateDto.getUserName())
                && Objects.nonNull(authCreateDto.getPosition())))
            throw new ValidationException("User dont valid");
        if (!(checkDepartment(authCreateDto.getDepartment()) && checkAuthRole(authCreateDto.getRole()) &&
        checkLanguage(authCreateDto.getLanguage()) &&
        checkPosition(authCreateDto.getPosition()) &&
                checkStatus(authCreateDto.getStatus())))
            throw new ValidationException("Not Found");
    }

    @Override
    public void validOnUpdate(AuthUpdateDto cd) throws ValidationException {
        if (Objects.isNull(cd.getId()))
            throw new ValidationException("User id not found");
    }
    private Boolean checkAuthRole(String role){
       Role value =  roleRepository.findAll().stream().
               filter(role1 -> role1.getCode().equalsIgnoreCase(role)).
               findFirst().orElseThrow(()->{
           throw new ValidationException("Role not found");
       });
       return true;
    }
    private Boolean checkLanguage(String lang){
        Language language = languageRepository.findAll().stream().
                filter(language1 -> language1.getCode().equalsIgnoreCase(lang)).
                findFirst().orElseThrow(()->{
                    throw new ValidationException("Language not found");
                });
        return true;
    }

    private Boolean checkPosition(String position){
        Positions positions = positionRepository.findAll().stream().
                filter(positions1 -> positions1.getCode().equalsIgnoreCase(position)).findFirst().orElseThrow(()->{
                    throw new ValidationException("Position not found");
                });
        return true;
    }

    private Boolean checkStatus(String status){
        for (Status value : Status.values()) {
            if (value.getCode().equalsIgnoreCase(status))
                return true;
        }
        return false;
    }

    private Boolean checkDepartment(String id){
        Department department = departmentRepository.findAll().stream().
                filter(department1 -> department1.getId().toString().equalsIgnoreCase(id)).findFirst()
                .orElseThrow(()->{
                   throw new ValidationException("department not found");
                });
        return true;
    }


}
