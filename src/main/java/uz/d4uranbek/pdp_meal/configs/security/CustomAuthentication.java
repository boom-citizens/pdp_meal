package uz.d4uranbek.pdp_meal.configs.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.auth.AuthRequestDto;


/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */

@Component

public class CustomAuthentication implements AuthenticationManager {
    private final PasswordEncoderConfigurer passwordEncoder;
    private final UserDetailsService userDetailsService;

    public CustomAuthentication(PasswordEncoderConfigurer passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());
        try {
            UserDetails user = (UserDetails) userDetailsService.loadUserByUsername(userName);
            if (!passwordEncoder.passwordEncoder().matches(password, user.getPassword())) {
                throw new BadCredentialsException("User not found");
            }
           /* if (!user.isEnabled()) {
                throw new DisabledException("User is not active");
            }
            if (!user.isAccountNonLocked()) {
                throw new DisabledException("User is not locked");
            }*/
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }

        return null;
    }

    public Authentication authenticate(AuthRequestDto dto) throws AuthenticationException {
        return authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
    }
}
