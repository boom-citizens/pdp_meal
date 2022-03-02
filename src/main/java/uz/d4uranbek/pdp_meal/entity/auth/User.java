package uz.d4uranbek.pdp_meal.entity.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.entity.Auditable;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Position;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;

import javax.persistence.*;

/**
 * @author D4uranbek ср. 7:34. 02.03.2022
 */

@Getter
@Setter
@NoArgsConstructor
@Entity

public class User extends Auditable {
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "language", referencedColumnName = "id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    @Column(name = "chat_id")
    private Long chatId;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "auth_position", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Position position;

    @Column(name = "status", nullable = false)
    private Status status;

}
