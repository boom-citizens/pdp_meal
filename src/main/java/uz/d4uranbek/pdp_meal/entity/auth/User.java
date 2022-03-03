package uz.d4uranbek.pdp_meal.entity.auth;

import lombok.AllArgsConstructor;
import uz.d4uranbek.pdp_meal.entity.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.d4uranbek.pdp_meal.entity.department.Department;
import uz.d4uranbek.pdp_meal.entity.language.Language;
import uz.d4uranbek.pdp_meal.entity.position.Positions;
import uz.d4uranbek.pdp_meal.entity.role.Role;
import uz.d4uranbek.pdp_meal.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author D4uranbek ср. 7:34. 02.03.2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable {
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "password",nullable = false)
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


   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "position_id")
    private Positions position;

    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public User(
            Long createBy, LocalDateTime createdAt, String userName,
                String phone, String password, String fullName, Language language,
                Role role, Long chatId, Positions position, Status status,Department department) {
        super( createBy, createdAt);
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.language = language;
        this.role = role;
        this.chatId = chatId;
        this.position = position;
        this.status = status;
        this.department = department;
    }


}
