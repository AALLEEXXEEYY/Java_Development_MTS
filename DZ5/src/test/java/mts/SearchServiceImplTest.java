package mts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchServiceImplTest {

    static Animal[] animals;
    @BeforeAll
    static void configuration(){
        animals = new Animal[4];

        animals[0] = new Cat("Breed","CAT1", "Character",BigDecimal.valueOf(100));
        animals[1] = new Cat("Breed","CAT2", "Character",BigDecimal.valueOf(100));
        animals[2] = new Cat("Breed","CAT3", "Character",BigDecimal.valueOf(100));
        animals[3] = new Cat("Breed","CAT4", "Character",BigDecimal.valueOf(100));

        animals[0].setBirthDate(LocalDate.of(2012,10,21));
        animals[1].setBirthDate(LocalDate.of(2015,6,26));
        animals[2].setBirthDate(LocalDate.of(1000,11,18));
        animals[3].setBirthDate(LocalDate.of(2016,12,31));

    }

    @Test
    @DisplayName("Тестирование ф-и поиска животных родившихся в високосном году")
    void _1_findLeapYearNamesTest() {
        SearchServiceImpl searchService = new SearchServiceImpl();
        String[] expectedNames = {"CAT1", "CAT4"};
        String[] actualNames = searchService.findLeapYearNames(animals);

        assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    @DisplayName("Тестирование ф-и поиска старшего животного")
    void _2_findOlderAnimalTest() {

        SearchServiceImpl searchService = new SearchServiceImpl();

        Animal[] expectedNames = {animals[0],animals[2]};
        Animal[] actualNames = searchService.findOlderAnimal(animals,LocalDate.of(2015,6,26));

        assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    @DisplayName("Тестирование ф-и поиска дубликатов животных")
    void _3_findDublicateTest() {

        animals[3] = new Cat("Breed","CAT1", "Character",BigDecimal.valueOf(100));
        animals[3].setBirthDate(LocalDate.of(2012,10,21));

        SearchServiceImpl searchService = new SearchServiceImpl();

        Animal[] expectedNames = {animals[0]};
        Animal[] actualNames = searchService.findDublicate(animals);

        assertArrayEquals(expectedNames, actualNames);

    }

}