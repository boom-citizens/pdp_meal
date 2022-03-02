package uz.d4uranbek.pdp_meal.services.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.configs.security.CustomAuthentication;
import uz.d4uranbek.pdp_meal.configs.security.UserDetails;
import uz.d4uranbek.pdp_meal.dto.auth.AuthRequestDto;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Service
public class AuthService {

    private final CustomAuthentication authenticationManager;
    private final UserDetailsService userService;

    public AuthService( CustomAuthentication authenticationManager, UserDetailsService userService) {

        this.authenticationManager = authenticationManager;
        this.userService = userService;
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
