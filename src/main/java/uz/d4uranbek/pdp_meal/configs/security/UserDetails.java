package uz.d4uranbek.pdp_meal.configs.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.permission.Permission;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */
@Getter
@Setter

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private String userName;
    private String phone;
    private String password;
    private String fullName;
    private Language language;
    private Role role;
    private Long chatId;
    private Positions position;
    private Status status;

    public UserDetails(User user) {
        this.userName = user.getUserName();
        this.phone = user.getPhone();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
        this.language = user.getLanguage();
        this.role = user.getRole();
        this.chatId = user.getChatId();
        this.position =  user.getPosition();
        this.status = user.getStatus();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.isNull(role))
            return authorities;

        authorities
                .add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));

        List<Permission> permissions = role.getPermissions();

        if (Objects.isNull(permissions)) {
            return authorities;
        }
        authorities.addAll(permissions.stream().
                map(permission -> new SimpleGrantedAuthority(permission.getCode())).
                collect(Collectors.toSet()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !(status.equals(Status.BLOCK));
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status.equals(Status.ACTIVE);
    }

}
