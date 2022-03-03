package uz.d4uranbek.pdp_meal.repository.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.d4uranbek.pdp_meal.entity.language.Language;

/**
 * Created by Elyor Ergashov
 *
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@Repository
@Transactional

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
