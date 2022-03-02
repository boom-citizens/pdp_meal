package uz.d4uranbek.pdp_meal.entity.permission;

import lombok.*;

import javax.persistence.*;

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

public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;


    public Permission(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
