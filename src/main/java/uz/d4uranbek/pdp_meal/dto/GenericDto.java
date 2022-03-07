package uz.d4uranbek.pdp_meal.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class GenericDto implements Dto {
    private Long id;

    public GenericDto(Long id) {
        this.id = id;
    }
}
