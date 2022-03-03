package uz.d4uranbek.pdp_meal.dto.department;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class DepartmentDto extends GenericDto {
    private String name;
    private Long headerChatId;

}
