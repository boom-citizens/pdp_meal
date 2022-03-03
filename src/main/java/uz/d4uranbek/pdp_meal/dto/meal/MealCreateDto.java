package uz.d4uranbek.pdp_meal.dto.meal;

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
public class MealCreateDto implements Dto {

    private String name;
    private String date;

}
