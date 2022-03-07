package uz.d4uranbek.pdp_meal.dto.department;

import lombok.*;
import uz.d4uranbek.pdp_meal.dto.GenericDto;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */
@Getter
@Setter
public class DepartmentUpdateDto extends GenericDto {
    private String name;
    private Long headerChatId;

    public DepartmentUpdateDto(Long id, String name, Long headerChatId) {
        super(id);
        this.name = name;
        this.headerChatId = headerChatId;
    }
}
