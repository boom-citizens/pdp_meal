package uz.d4uranbek.pdp_meal.dto.department;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

import lombok.*;
import uz.d4uranbek.pdp_meal.dto.GenericDto;


@Getter
@Setter


public class DepartmentDto extends GenericDto {
    private String name;
    private Long headerChatId;

    @Builder(builderMethodName = "childrenBuilder")
    public DepartmentDto(Long id, String name, Long headerChatId) {
        super(id);
        this.name = name;
        this.headerChatId = headerChatId;
    }
}
