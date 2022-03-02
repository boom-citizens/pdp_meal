package uz.d4uranbek.pdp_meal.repository.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.d4uranbek.pdp_meal.entity.permission.Permission;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
