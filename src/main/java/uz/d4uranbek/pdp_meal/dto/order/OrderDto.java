package uz.d4uranbek.pdp_meal.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

import java.time.LocalDate;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
public class OrderDto extends GenericDto {

    private Long userId;
    private Long mealId;
    private LocalDate date;
    private boolean received;

    @Builder(builderMethodName = "childBuilder")
    public OrderDto(Long id, Long userId, Long mealId, LocalDate date, boolean received) {
        super(id);
        this.userId = userId;
        this.mealId = mealId;
        this.date = date;
        this.received = received;
    }
}
