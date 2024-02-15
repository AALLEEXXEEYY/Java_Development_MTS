package mts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractAnimalTest {

    private static Cat cat;
    private static Dog dog;
    private static Wolf wolf;
    private static Shark shark;

    @BeforeAll
    static void setUP(){
        cat=new Cat("Breed","CAT", "Character",BigDecimal.valueOf(100));
        cat.setBirthDate(LocalDate.now());
        dog=new Dog("Breed","DOG","Character", BigDecimal.valueOf(100));
        wolf=new Wolf("Breed","WOLF","Character");
        shark=new Shark("Breed","SHARK","Character");
    }

    @DisplayName("Сравнивание одинаковых кошек")
    @Test
    void testTwinsCats() {
        Cat cat1=new Cat("Breed","CAT", "Character",BigDecimal.valueOf(100));
        cat1.setBirthDate(LocalDate.now());
        assertTrue(cat.equals(cat1));

    }

    @DisplayName("Сравнивание разных кошек")
    @Test
    void testNotTwinsCats() {

        assertFalse(cat.equals(new Cat("British","CAT1", "Cute",BigDecimal.valueOf(200))));

    }

    @DisplayName("Сравнивание кошки с волком")
    @Test
    void testCatIsWolf() {

        assertFalse(cat.equals(new Wolf("Breed","WOLF","Character")));
    }

    @DisplayName("Сравнивание кошки c собакой с одинаковыми параметрами")
    @Test
    void estNotTwinsCats() {

        assertFalse(cat.equals(new Dog("Breed","CAT", "Character", BigDecimal.valueOf(100))));

    }






}