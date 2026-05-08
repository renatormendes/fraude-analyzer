package com.projeto.ml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Garante que arquivos em /static sejam servidos corretamente
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
