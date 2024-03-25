package serviceTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.dz7.animals.*;
import ru.mts.dz7.service.AnimalRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalRepositoryTest {

//    AnimalRepositoryImpl animalsRepository= new AnimalRepositoryImpl();
//    @BeforeEach
//    void initRepository(){
//        animalsRepository.animals = new Animal[8];
//        animalsRepository.animals[0] = new Dog("Breed", "DOG1", "Character", BigDecimal.valueOf(100));
//        animalsRepository.animals[1] = new Dog("Breed", "DOG2", "Character", BigDecimal.valueOf(100));
//        animalsRepository.animals[2] = new Cat("Breed", "CAT1", "Character", BigDecimal.valueOf(100));
//        animalsRepository.animals[3] = new Cat("Breed", "CAT2", "Character", BigDecimal.valueOf(100));
//        animalsRepository.animals[4] = new  Wolf("Breed", "WOLF1", "Character");
//        animalsRepository.animals[5] = new  Wolf("Breed", "WOLF2", "Character");
//        animalsRepository.animals[6]=  new Shark("Breed","SHARK1","Character");
//        animalsRepository.animals[7]=  new Shark("Breed","SHARK2","Character");
//
//
//        animalsRepository.animals[0].setBirthDate(LocalDate.of(2012,4,20));
//        animalsRepository.animals[1].setBirthDate(LocalDate.of(2010,5,15));
//        animalsRepository.animals[2].setBirthDate(LocalDate.of(2010,11,13));
//        animalsRepository.animals[3].setBirthDate(LocalDate.of(2013,5,16));
//        animalsRepository.animals[4].setBirthDate(LocalDate.of(2020,1,6));
//        animalsRepository.animals[5].setBirthDate(LocalDate.of(2022,7,1));
//        animalsRepository.animals[6].setBirthDate(LocalDate.of(2023,1,25));
//        animalsRepository.animals[7].setBirthDate(LocalDate.of(2000,8,28));
//    }
//
//
//    @Test
//    @DisplayName("Test for search animals birth in leap year")
//    void findLeapYearNamesTest(){
//        String[] names = {"Breed = Breed, name = DOG1, character = Character, cost = 100.00, birthday = 2012-04-20",
//                          "Breed = Breed, name = WOLF1, character = Character, cost = null, birthday = 2020-01-06",
//                          "Breed = Breed, name = SHARK2, character = Character, cost = null, birthday = 2000-08-28"
//        };
//        assertArrayEquals(names,animalsRepository.findLeapYearNames());
//    }
//
//    @Test
//    @DisplayName("Test for search animals older 1 year")
//    void findOlderTest(){
//        assertArrayEquals(animalsRepository.animals,animalsRepository.findOlderAnimal(1));
//    }
//
//
//
//
//    @Test
//    @DisplayName("Test for search duplicate animals")
//    void findDuplicateTest(){
//        Set<Animal> set = Set.of(new Animal[]{animalsRepository.animals[0],animalsRepository.animals[4]});
//        animalsRepository.animals[2]=animalsRepository.animals[0];
//        animalsRepository.animals[5] = animalsRepository.animals[4];
//        assertEquals(set,animalsRepository.findDuplicate());
//    }
//






}


