package uz.d4uranbek.pdp_meal.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.d4uranbek.pdp_meal.entity.auth.User;

import java.util.Optional;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/2/2022
 * @project : mealDeliver
 */

public interface AuthUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
