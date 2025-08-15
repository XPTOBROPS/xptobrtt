package br.unipe.vvauto.projetounitariointegrado.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for customizing the Jackson {@link ObjectMapper} bean.
 * <p>
 * Registers the {@link JavaTimeModule} to enable proper serialization and deserialization
 * of Java 8 date and time API types (e.g., {@link java.time.LocalDateTime}) in JSON responses.
 * This ensures that date and time fields are handled correctly throughout the application.
 * </p>
 *
 * @author Carlos Diego Quirino Lima
 */
@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
