package ru.mts.dz7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import ru.mts.dz7.config.CreateServiceProperties;
import ru.mts.dz7.service.CreateAnimalServiceImpl;

@TestConfiguration
public class TestChangeConfiguration {

    @Autowired
    CreateServiceProperties properties;

    @Bean
    @Primary
    CreateAnimalServiceImpl testCreateAnimalService(){
        return new CreateAnimalServiceImpl(properties);
    }
}
