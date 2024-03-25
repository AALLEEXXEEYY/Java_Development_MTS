package ru.mts.dz7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.dz7.service.CreateAnimalServiceImpl;
import ru.mts.dz7.service.ScheduleOfOutput;

@Configuration
@EnableConfigurationProperties(CreateServiceProperties.class)
public class CreateServiceConfiguration {
    @Autowired
    CreateServiceProperties properties;


    public CreateServiceProperties getProperties() {
        return properties;
    }



    @Bean
    @Scope("prototype")
    CreateAnimalServiceImpl createAnimalService(){
        return new CreateAnimalServiceImpl(properties);
    }

    @Bean
    ScheduleOfOutput characteristics(){
        return new ScheduleOfOutput();
    }
}
