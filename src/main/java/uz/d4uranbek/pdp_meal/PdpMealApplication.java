package uz.d4uranbek.pdp_meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.d4uranbek.pdp_meal.bot.PDPFoodBot;
import uz.d4uranbek.pdp_meal.entity.auth.User;
import uz.d4uranbek.pdp_meal.repository.permission.PermissionRepository;
import uz.d4uranbek.pdp_meal.repository.role.RoleRepository;

@SpringBootApplication
public class PdpMealApplication /*implements CommandLineRunner */{

    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public PdpMealApplication(PasswordEncoder passwordEncoder, PermissionRepository permissionRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PdpMealApplication.class, args);
        PDPFoodBot telegramBotConfigurer=run.getBean(PDPFoodBot.class);
        telegramBotConfigurer.run();
    }



//    @Override
    public void run(String... args) throws Exception {
/*
        Positions teacher = new Positions("TEACHER","Teacher");
        Positions calculator = new Positions("CALCULATOR","Calculator");
        Role admin = new Role("ADMIN", "Admin");
        Language uz = new Language("UZ", "Uzbek");
        User adminUser = new User(-1L, LocalDateTime.now(), "elyor", "998880077420", "7722",
                "Elyor Ergashov", uz, admin, -1L, List.of(teacher,calculator), Status.ACTIVE);*/

        User user1 = new User();
        user1.setUserName("mr");
        user1.setPassword(passwordEncoder.encode("7722"));

        User user2 = new User();
        user2.setUserName("mrElyor");
        user2.setPassword(passwordEncoder.encode("7722"));



        /*roleRepository.saveAll(List.of(admin));
        authUserRepository.saveAll(List.of(adminUser));*/

       /* Permission view = new Permission("ROLE-VIEW", "role-view");
        Permission create = new Permission("ROLE-CREATE", "role-create");
        Permission delete = new Permission("ROLE-DELETE", "role-delete");*/

     //   admin.setPermissions(Arrays.asList(view, create, delete));
       // employee.setPermissions(Collections.singletonList(view));
//        roleRepository.saveAll(List.of(admin));

    }
}
