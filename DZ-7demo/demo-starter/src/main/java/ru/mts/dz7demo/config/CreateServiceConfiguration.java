package ru.mts.dz7demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.dz7demo.service.CreateAnimalServiceImpl;

@Configuration
@EnableConfigurationProperties(CreateServiceProperties.class)
public class CreateServiceConfiguration {
    @Autowired
    CreateServiceProperties properties;

    @Bean
    @Scope("prototype")
    CreateAnimalServiceImpl createAnimalService(){
        return new CreateAnimalServiceImpl(properties);
    }
}
