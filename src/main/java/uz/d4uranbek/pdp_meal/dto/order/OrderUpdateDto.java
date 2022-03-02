package uz.d4uranbek.pdp_meal.dto.order;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

import java.time.LocalDate;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
public class OrderUpdateDto extends GenericDto {

    private Long userId;
    private Long mealId;
    private String date;
    private boolean received;

    public OrderUpdateDto(Long id, Long userId, Long mealId, String date, boolean received) {
        super(id);
        this.userId = userId;
        this.mealId = mealId;
        this.date = date;
        this.received = received;
    }
}
