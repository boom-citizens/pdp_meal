package uz.d4uranbek.pdp_meal.repository.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.d4uranbek.pdp_meal.entity.position.Positions;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@Repository
@Transactional
public interface PositionRepository extends JpaRepository<Positions,Long> {
}
