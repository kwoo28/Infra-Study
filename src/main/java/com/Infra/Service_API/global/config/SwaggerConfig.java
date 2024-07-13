package com.Infra.Service_API.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String serverUrl;

    public SwaggerConfig(
            @Value("${swagger.server-url}") String serverUrl
    ) {
        this.serverUrl = serverUrl;
    }

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl(serverUrl);
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo())
                .addServersItem(server);
    }

    private Info apiInfo() {
        return new Info()
                .title("Service API")
                .description("Springdoc을 사용한 Swagger UI")
                .version("1.0.0");
    }
}
