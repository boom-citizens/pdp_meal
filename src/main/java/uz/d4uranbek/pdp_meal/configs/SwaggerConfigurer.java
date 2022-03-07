package uz.d4uranbek.pdp_meal.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.protocols(new HashSet<>(List.of("http","https")));
        docket.apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("uz.d4uranbek.pdp_meal"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot With Swagger")
                .description("This is test project for integrating spring boot with swagger")
                .version("1.0")
                .contact(new Contact("test","boom.uz","boom@gmail.com"))
                .licenseUrl("https://pdp.uz")
                .build();
    }
}
