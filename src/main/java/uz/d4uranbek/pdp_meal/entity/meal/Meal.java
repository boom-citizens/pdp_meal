package uz.d4uranbek.pdp_meal.entity.meal;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author D4uranbek ср. 12:21. 02.03.2022
 */

@Getter
@Setter
@Entity
@Table(name = "meals")
public class Meal extends Auditable {

    @Column(nullable = false)
    private String name;

    private LocalDate date;

}
