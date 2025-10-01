package br.edu.ifsp.ricael.api_login_users;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*") // coloque o domínio do seu front
            .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}