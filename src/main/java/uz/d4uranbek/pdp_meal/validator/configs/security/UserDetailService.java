package uz.d4uranbek.pdp_meal.validator.configs.security;



import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.repository.auth.AuthRepository;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */

@Service

public class UserDetailService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final AuthRepository repository;

    public UserDetailService(PasswordEncoder passwordEncoder, AuthRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username).orElseThrow(()->{
            throw new UsernameNotFoundException("User not found");
        });
        return new UserDetails(user);
    }
}
