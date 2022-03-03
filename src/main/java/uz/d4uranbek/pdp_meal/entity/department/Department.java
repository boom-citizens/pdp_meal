package uz.d4uranbek.pdp_meal.entity.department;

import lombok.Getter;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.entity.auth.User;

import javax.persistence.*;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/3/2022
 * @project : mealDeliver
 */
@Getter
@Setter
@Entity

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User userId;

}
