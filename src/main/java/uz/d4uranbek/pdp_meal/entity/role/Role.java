package uz.d4uranbek.pdp_meal.entity.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.entity.permission.Permission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/2/2022
 * @project : mealDeliver
 */

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "auth_role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission>  permissions =new ArrayList<>();


    public Role(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
