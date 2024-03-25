package ru.mts.dz7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.service.CreateAnimalService;
import ru.mts.dz7.service.CreateAnimalServiceImpl;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateAnimalServiceTest {
    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    @Test
    void  checkTest(){
        Map<String, List<Animal>> createdAnimal2 = createAnimalService.createAnimalsImpl();
//        Map<String, List<Animal>> createdAnimal2 = createAnimalService.myCreateAnimals();

        for (Map.Entry<String, List<Animal>> entry : createdAnimal2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }



    @Test
    public void testMyCreateAnimals() {

        Map<String, List<Animal>> animalsMap = createAnimalService.myCreateAnimals();

        assertNotNull(animalsMap);
        assertEquals(CreateAnimalService.AnimalType.getCountEnumAnimals(), animalsMap.size());

        for (Map.Entry<String, List<Animal>> entry : animalsMap.entrySet()) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
            assertEquals(1, entry.getValue().size());
            assertNotNull(entry.getValue().get(0));
        }
    }

    @Test
    void testRandomnessOfAnimalType() {

        Map<String, List<Animal>> result1 = createAnimalService.createAnimals(1);
        Map<String, List<Animal>> result2 =createAnimalService.createAnimals(4);

        boolean typesDiffer = false;
        for (String type : result1.keySet()) {
            if (result2.containsKey(type)) {
                typesDiffer = true;
                break;
            }
        }
        assertTrue(typesDiffer);
    }



}
