package uz.d4uranbek.pdp_meal.dto.order;

import lombok.*;
import uz.d4uranbek.pdp_meal.dto.Dto;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto implements Dto {

    private Long userId;
    private Long mealId;
    private String date;

}
