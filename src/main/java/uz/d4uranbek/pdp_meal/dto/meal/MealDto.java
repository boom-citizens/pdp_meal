package uz.d4uranbek.pdp_meal.dto.meal;

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
public class MealDto extends GenericDto {

    private String name;
    private String date;


    @Builder(builderMethodName = "childBuilder")
    public MealDto(Long id, String name, String date) {
        super(id);
        this.name = name;
        this.date = date;
    }
}
