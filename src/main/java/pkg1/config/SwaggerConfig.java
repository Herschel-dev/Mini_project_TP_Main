// SwaggerConfig.java
package pkg1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI teacherPanelOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Teacher Panel API")
                .description("REST endpoints for Smart College Assistant Teacher Panel")
                .version("v1.0"));
    }

    @Bean
    public GroupedOpenApi teacherPanelApi() {
        return GroupedOpenApi.builder()
            .group("teacher-panel")
            .packagesToScan("pkg1.controller")
            .build();
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
