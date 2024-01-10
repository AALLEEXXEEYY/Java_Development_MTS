package ru.mts;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;

    public AbstractAnimal(){
        birthDate = LocalDate.now().minusDays((long)(365*2*Math.random()));
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() !=obj.getClass())
            return false;
        AbstractAnimal animal = (AbstractAnimal)obj;
        if (!getBread().equals(animal.getBread()))
            return false;
        if (!getCharacter().equals(animal.getCharacter()))
            return false;
        if (!getBirthDate().equals(animal.getBirthDate()))
            return false;
//        if (!getCost().equals(animal.getCost()))
//            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Breed = " + breed + ", name = " + name + ", character = " + character + ", cost = " + cost+", birthDate=" + birthDate ;
    }
}