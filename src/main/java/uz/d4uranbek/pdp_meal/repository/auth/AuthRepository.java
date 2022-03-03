package uz.d4uranbek.pdp_meal.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.repository.AbstractRepository;

import java.util.Optional;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Transactional
@Repository
public interface AuthRepository extends JpaRepository<User, Long> , AbstractRepository {


    Optional<User> findByUserName(String userName);
}
