package serviceTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.config.CreateServiceProperties;
import ru.mts.dz7.service.CreateAnimalService;
import ru.mts.dz7.service.CreateAnimalServiceImpl;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAnimalServiceTest {


    @Test
    @DisplayName("Test function getRandomAnimal()")
    void getRandomAnimalTest() {

        CreateServiceProperties properties = new CreateServiceProperties();
        properties.setCatName(new String[]{"CatName1", "CatName2"});

        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl(properties);
        service.setType(CreateAnimalService.AnimalType.CAT);

        Animal animal = service.getRandomAnimal();

        assertNotNull(animal);
        assertTrue(animal instanceof Animal);

        assertNotNull(animal.getName());
        assertFalse(animal.getName().isEmpty());

    }


}
