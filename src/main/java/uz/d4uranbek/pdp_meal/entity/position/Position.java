package uz.d4uranbek.pdp_meal.entity.position;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;
}
