package uz.d4uranbek.pdp_meal.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.configs.security.CustomAuthentication;
import uz.d4uranbek.pdp_meal.configs.security.UserDetails;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthRequestDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;
import uz.d4uranbek.pdp_meal.mapper.auth.AuthMapper;
import uz.d4uranbek.pdp_meal.repository.auth.AuthRepository;
import uz.d4uranbek.pdp_meal.repository.department.DepartmentRepository;
import uz.d4uranbek.pdp_meal.repository.language.LanguageRepository;
import uz.d4uranbek.pdp_meal.repository.position.PositionRepository;
import uz.d4uranbek.pdp_meal.repository.role.RoleRepository;
import uz.d4uranbek.pdp_meal.service.AbstractService;
import uz.d4uranbek.pdp_meal.validator.auth.AuthValidator;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */


@Service
public class AuthServiceImpl extends AbstractService<AuthRepository,
        AuthMapper, AuthValidator> implements AuthService {

    private final CustomAuthentication authenticationManager;
    private final UserDetailsService userService;
    private final AuthRepository repository;
    private final AuthMapper mapper;
    private final AuthValidator validator;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public AuthServiceImpl(CustomAuthentication authenticationManager, UserDetailsService userService, AuthRepository repository, AuthMapper mapper, AuthValidator validator, PasswordEncoder passwordEncoder, RoleRepository roleRepository, LanguageRepository languageRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository) {
        super(repository, mapper, validator);
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.languageRepository = languageRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Long create(AuthCreateDto createDto) {
        validator.validOnCreate(createDto);
        User user = mapper.fromCreateDto(createDto);
        user.setPassword(passwordEncoder.encode(createDto.getPassword()));
        user.setLanguage(getLanguage(createDto.getLanguage()));
        user.setRole(getAuthRole(createDto.getRole()));
        user.setPosition(getPosition(createDto.getPosition()));
        user.setStatus(Status.getStatus(createDto.getStatus()));
        user.setDepartment(getDepartment(createDto.getDepartment()));
        repository.save(user);
        return user.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(AuthUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        User user = repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        if (!updateDto.getUserName().equals("")) {
            user.setUserName(updateDto.getUserName());
        }
        if (!updateDto.getFullName().equals("")) {
            user.setFullName(updateDto.getFullName());
        }

        if (!updateDto.getPhone().equals("")) {
            user.setPhone(updateDto.getPhone());
        }
        repository.save(user);
        return null;
    }

    @Override
    public List<AuthDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<AuthDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public AuthDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        }));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


    public ResponseEntity<String> login(AuthRequestDto dto) {
        try {
            authenticationManager.authenticate(dto);
        } catch (Exception e) {
            throw new AccessDeniedException("INVALID_CREDENTIALS");
        }

        UserDetails user = (UserDetails) userService.loadUserByUsername(dto.getUserName());
        return ResponseEntity.ok(user.getUsername());
    }

    private Role getAuthRole(String role){
       return roleRepository.findAll().stream().
                filter(role1 -> role1.getCode().equalsIgnoreCase(role)).
                findFirst().orElseThrow(()->{
                    throw new RuntimeException("Role not found");
                });

    }
    private Language getLanguage(String lang){
        return  languageRepository.findAll().stream().
                filter(language1 -> language1.getCode().equalsIgnoreCase(lang)).
                findFirst().orElseThrow(()->{
                    throw new RuntimeException("Language not found");
                });

    }

    private Positions getPosition(String position){
         return  positionRepository.findAll().stream().
                filter(positions1 -> positions1.getCode().equalsIgnoreCase(position)).findFirst().orElseThrow(()->{
                    throw new RuntimeException("Position not found");
                });

    }

    private Department getDepartment(String department){
        return departmentRepository.findAll().stream().filter(department1 ->
                department1.getId().toString().equalsIgnoreCase(department)).findFirst().orElseThrow(()->{
                    throw new RuntimeException("Department not found");
        });
    }


    public void setLanguage(long chatId, String lang) {
        repository.setLanguage(chatId,lang);
    }
}
