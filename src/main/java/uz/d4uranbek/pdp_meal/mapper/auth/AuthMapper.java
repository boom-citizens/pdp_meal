package uz.d4uranbek.pdp_meal.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.d4uranbek.pdp_meal.dto.auth.AuthCreateDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthDto;
import uz.d4uranbek.pdp_meal.dto.auth.AuthUpdateDto;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.mapper.BaseMapper;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Component
@Mapper(componentModel = "spring")

public class AuthMapper implements BaseMapper<User, AuthDto, AuthCreateDto, AuthUpdateDto> {

    @Override
    public AuthDto toDto(User user) {
        return null;
    }

    @Override
    public List<AuthDto> toDto(List<User> e) {
        return null;
    }

    @Override
    public User fromCreateDto(AuthCreateDto authCreateDto) {
        return null;
    }

    @Override
    public User fromUpdateDto(AuthUpdateDto authUpdateDto) {
        return null;
    }
}
