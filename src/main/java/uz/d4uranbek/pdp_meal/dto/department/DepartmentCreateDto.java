package uz.d4uranbek.pdp_meal.dto.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.dto.Dto;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentCreateDto implements Dto {
    private String name;
    private Long headerChatId;
}
