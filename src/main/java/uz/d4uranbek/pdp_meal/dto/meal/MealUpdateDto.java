package uz.d4uranbek.pdp_meal.dto.meal;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
public class MealUpdateDto extends GenericDto {

    private String name;
    private String date;

    public MealUpdateDto(Long id, String name, String date) {
        super(id);
        this.name = name;
        this.date = date;
    }
}
