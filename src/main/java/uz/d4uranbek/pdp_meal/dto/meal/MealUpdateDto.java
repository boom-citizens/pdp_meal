package uz.d4uranbek.pdp_meal.dto.meal;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

import java.time.LocalDate;

/**
 * @author D4uranbek ср. 12:57. 02.03.2022
 */

@Getter
@Setter
public class MealUpdateDto extends GenericDto {

    private String name;

    private LocalDate date;

    public MealUpdateDto(Long id, String name, LocalDate date) {
        super(id);
        this.name = name;
        this.date = date;
    }
}
