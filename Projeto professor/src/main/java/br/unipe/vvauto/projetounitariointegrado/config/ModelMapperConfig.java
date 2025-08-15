package br.unipe.vvauto.projetounitariointegrado.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the ModelMapper bean.
 * <p>
 * Registers a {@link ModelMapper} instance as a Spring bean, enabling object mapping
 * between DTOs and entities throughout the application. ModelMapper simplifies the
 * conversion of objects by automatically mapping fields with matching names and types.
 * </p>
 *
 * @author Carlos Diego Quirino Lima
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
