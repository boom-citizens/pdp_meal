package uz.d4uranbek.pdp_meal.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import uz.d4uranbek.pdp_meal.entity.Auditable;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author D4uranbek ср. 12:26. 02.03.2022
 */

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    @JsonIgnore
    private Meal meal;

    private LocalDate date;

    @Column(name = "is_received", nullable = false)
    @ColumnDefault(value = "false")
    private boolean received;
}
