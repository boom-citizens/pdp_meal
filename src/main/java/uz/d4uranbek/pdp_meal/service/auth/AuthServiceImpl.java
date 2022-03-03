package uz.d4uranbek.pdp_meal.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.configs.security.CustomAuthentication;
import uz.d4uranbek.pdp_meal.configs.security.UserDetails;
import uz.d4uranbek.pdp_meal.criteria.GenericCriteria;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthRequestDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.mapper.auth.AuthMapper;
import uz.d4uranbek.pdp_meal.repository.auth.AuthRepository;
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
        AuthMapper, AuthValidator> implements AuthService{

    private final CustomAuthentication authenticationManager;
    private final UserDetailsService userService;
    private static AuthRepository repository;
    private static AuthMapper mapper;
    private static AuthValidator validator;

    @Autowired
    public AuthServiceImpl(CustomAuthentication authenticationManager, UserDetailsService userService) {
        super(repository,mapper,validator);
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public Long create(AuthCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(AuthUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<AuthDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<AuthDto> getAllById(GenericCriteria criteria, Long id) {
        return null;
    }

    @Override
    public AuthDto get(Long id) {
        return null;
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
}
