package ru.mts.dz7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.dz7.animals.*;
import ru.mts.dz7.exeptions.EmptyAnimalListException;
import ru.mts.dz7.exeptions.CustomIllegalArgumentException;
import ru.mts.dz7.service.AnimalRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnimalRepositoryTest {
    @Autowired
    AnimalRepositoryImpl animalsRepository;

    @BeforeEach
    public void initRepository() {

        animalsRepository.animals = new CopyOnWriteArrayList<>();
        animalsRepository.animals.add(new Dog("1","1", "1",BigDecimal.valueOf(1200)));
        animalsRepository.animals.add(new Dog("2","2", "2",BigDecimal.valueOf(2000)));
        animalsRepository.animals.add(new Dog("3","3", "3",BigDecimal.valueOf(600)));
        animalsRepository.animals.add(new Dog("4","4", "4",BigDecimal.valueOf(500)));
        animalsRepository.animals.add(new Cat("5","5", "5",BigDecimal.valueOf(1500)));
        animalsRepository.animals.add(new Cat("6","6", "6",BigDecimal.valueOf(1)));
        animalsRepository.animals.add(new Shark("7","7", "7"));
        animalsRepository.animals.add(new Shark("8","8", "8"));


        animalsRepository.animals.get(0).setBirthDate(LocalDate.of(2012,4,20));
        animalsRepository.animals.get(1).setBirthDate(LocalDate.of(2010,5,15));
        animalsRepository.animals.get(2).setBirthDate(LocalDate.of(2010,11,13));
        animalsRepository.animals.get(3).setBirthDate(LocalDate.of(2013,5,16));
        animalsRepository.animals.get(4).setBirthDate(LocalDate.of(2020,1,6));
        animalsRepository.animals.get(5).setBirthDate(LocalDate.of(2022,7,1));
        animalsRepository.animals.get(6).setBirthDate(LocalDate.of(2024,1,25));
        animalsRepository.animals.get(7).setBirthDate(LocalDate.of(2001,8,28));
    }



    @Test
    @DisplayName("Test for search animals birth in leap year")
    public void testFindLeapYearNames() {

        try {
            Map<String, LocalDate> result = animalsRepository.findLeapYearNames();
            assertEquals(3, result.size());
            assertEquals(LocalDate.of(2012, 4, 20), result.get("1"));
            assertEquals(LocalDate.of(2020, 1, 6), result.get("5"));
            assertEquals(LocalDate.of(2024, 1, 25), result.get("7"));
        }
        catch (EmptyAnimalListException e) {
            Assertions.assertThrows(EmptyAnimalListException.class,()->{
                animalsRepository.findDuplicate();
            });
        }
    }


    @Test
    @DisplayName("Test for search amount animals older some ages")
    void testFindOlderAnimal(int age) {
        try {


            Map<Animal, Integer> expected = new ConcurrentHashMap<>();
            expected.put(animalsRepository.animals.get(0), Period.between(animalsRepository.animals.get(0).getBirthDate(), LocalDate.now()).getYears());
            expected.put(animalsRepository.animals.get(1), Period.between(animalsRepository.animals.get(1).getBirthDate(), LocalDate.now()).getYears());
            expected.put(animalsRepository.animals.get(2), Period.between(animalsRepository.animals.get(2).getBirthDate(), LocalDate.now()).getYears());
            expected.put(animalsRepository.animals.get(3), Period.between(animalsRepository.animals.get(3).getBirthDate(), LocalDate.now()).getYears());
            expected.put(animalsRepository.animals.get(7), Period.between(animalsRepository.animals.get(7).getBirthDate(), LocalDate.now()).getYears());

            Map<Animal, Integer> result = animalsRepository.findOlderAnimal(10);

            assertEquals(expected.size(), result.size());
        }
        catch (CustomIllegalArgumentException ex){
            Assertions.assertThrows(CustomIllegalArgumentException.class,()->{
                animalsRepository.findOlderAnimal(age);
            });
        }
        catch (EmptyAnimalListException ex){
            Assertions.assertThrows(EmptyAnimalListException.class,()->{
                animalsRepository.findOlderAnimal(age);
            });
        }
    }


    @Test
    @DisplayName("Test for search duplicate animals")
    void testFindDuplicate() {
        try {

            Map<String, List<Animal>> result = animalsRepository.findDuplicate();

            assertTrue(result.isEmpty());
        }
        catch (EmptyAnimalListException e) {
            Assertions.assertThrows(EmptyAnimalListException.class, () -> {
                animalsRepository.findDuplicate();
            });
        }
    }

    @Test
    void findAvgAgeTest(){
        try {


            int totalYears = 0;
            for (Animal animal : animalsRepository.animals) {
                totalYears += Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            }
            double expectedAverageAge = (double) totalYears / animalsRepository.animals.size();
            assertEquals(expectedAverageAge, animalsRepository.findAverageAge());
        }
        catch (EmptyAnimalListException e) {
            Assertions.assertThrows(EmptyAnimalListException.class,()->{
                animalsRepository.findAverageAge();
            });
        }

    }
    @Test
    void findOldAndExpensiveTest(){
        try {


            List<Animal> expectedAnimals = new CopyOnWriteArrayList<>();
            animalsRepository.animals.get(0).setBirthDate(LocalDate.now().minusYears(7));
            animalsRepository.animals.get(1).setBirthDate(LocalDate.now().minusYears(8));
            animalsRepository.animals.get(4).setBirthDate(LocalDate.now().minusYears(9));
            expectedAnimals.add(animalsRepository.animals.get(0));
            expectedAnimals.add(animalsRepository.animals.get(1));
            expectedAnimals.add(animalsRepository.animals.get(4));


            Collections.sort(expectedAnimals, Comparator.comparing(Animal::getBirthDate));
            assertEquals(expectedAnimals, animalsRepository.findOldAndExpensive());
        }
        catch (EmptyAnimalListException e) {
            Assertions.assertThrows(EmptyAnimalListException.class,()->{
                animalsRepository.findOldAndExpensive();
            });
        }


    }
    @Test
    void findMinCostTest(){
        try {


            List<String> expectedNames = new CopyOnWriteArrayList<>();
            expectedNames.add("5");
            expectedNames.add("1");
            expectedNames.add("2");

            List<String> resultNames = animalsRepository.findMinConstAnimals();

            Collections.sort(expectedNames);
            Collections.sort(resultNames);
            assertEquals(expectedNames, resultNames);
        }
        catch (EmptyAnimalListException e) {
            Assertions.assertThrows(EmptyAnimalListException.class,()->{
                animalsRepository.findMinConstAnimals();
            });
        }

    }

}
