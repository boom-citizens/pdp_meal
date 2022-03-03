package uz.d4uranbek.pdp_meal.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.entity.meal.Meal;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
public class OrderDto extends GenericDto {

    private User user;
    private Meal meal;
    private String date;
    private boolean received;

    @Builder(builderMethodName = "childBuilder")
    public OrderDto(Long id, User user, Meal meal, String date, boolean received) {
        super(id);
        this.user = user;
        this.meal = meal;
        this.date = date;
        this.received = received;
    }
}
