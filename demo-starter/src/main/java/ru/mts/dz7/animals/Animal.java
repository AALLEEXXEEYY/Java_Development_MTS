package ru.mts.dz7.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {

    String getBread();
    String getName();

    BigDecimal getCost();
    String getCharacter();
    LocalDate getBirthDate();
    LocalDate setBirthDate(LocalDate birthDate);

}
