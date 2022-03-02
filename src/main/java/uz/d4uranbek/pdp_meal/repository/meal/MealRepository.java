package uz.d4uranbek.pdp_meal.repository.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;
import uz.d4uranbek.pdp_meal.repository.AbstractRepository;

/**
 * @author D4uranbek ср. 18:27. 02.03.2022
 */
@Transactional
@Repository
public interface MealRepository extends JpaRepository<Meal, Long>, AbstractRepository {

}
