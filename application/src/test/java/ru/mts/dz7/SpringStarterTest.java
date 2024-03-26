package ru.mts.dz7;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.dz7.animals.Wolf;
import ru.mts.dz7.config.CreateServiceConfiguration;
import ru.mts.dz7.service.AnimalRepositoryImpl;
import ru.mts.dz7.service.CreateAnimalServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class SpringStarterTest {
    @Autowired
    CreateAnimalServiceImpl createService;
    @Autowired
    AnimalRepositoryImpl repository;
    @Autowired
    CreateServiceConfiguration configuration;

    private String catName;
    private String dogName;
    private String sharkName;
    private String wolfName;

    @BeforeEach
    public  void init(){
        catName= configuration.getProperties().getCatName()[0];
        dogName= configuration.getProperties().getDogName()[0];
        sharkName= configuration.getProperties().getSharkName()[0];
        wolfName= configuration.getProperties().getWolfName()[0];

    }




    @Test
    void postProcessorTest() {
        assertNotEquals(null, createService.getType());
    }

    @Test
    void testConfigInitCost() {
        assertNotNull(createService.getCatCost());
        assertNotNull(createService.getDogCost());
        assertNull(createService.getWolfCost());
        assertNull(createService.getSharkCost());
    }



    @Test
    void testConfigInit() {
        init();
        assertEquals("Cat_test", catName);
        assertEquals("Dog_test", dogName);
        assertEquals("Wolf_test", wolfName);
        assertEquals("Shark_test", sharkName);

    }


}