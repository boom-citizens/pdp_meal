package uz.d4uranbek.pdp_meal.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.d4uranbek.pdp_meal.entity.order.Order;
import uz.d4uranbek.pdp_meal.repository.AbstractRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author D4uranbek ср. 18:29. 02.03.2022
 */
@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, AbstractRepository {

    List<Order> findAllByDate(LocalDate localDate);

    List<Order> findAllByMealId(Long mealId);

    List<Order> findAllByUserId(Long userId);
}
