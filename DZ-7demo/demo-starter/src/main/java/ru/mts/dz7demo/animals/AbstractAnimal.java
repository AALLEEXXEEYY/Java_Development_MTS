package ru.mts.dz7demo.animals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;

    public AbstractAnimal(){
        birthDate = LocalDate.now().minusDays((long)(365*4*Math.random()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() !=obj.getClass())
            return false;
        AbstractAnimal animal = (AbstractAnimal)obj;
        if (!Objects.equals(getBread(), animal.getBread()))
            return false;
        if (!Objects.equals(getCharacter(), animal.getCharacter()))
            return false;
        if (!Objects.equals(getBirthDate(), animal.getBirthDate()))
            return false;
        if (!Objects.equals(getCost(),animal.getCost()))
            return false;
        if (!Objects.equals(getBirthDate(), animal.getBirthDate()))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Breed = " + breed + ", name = " + name + ", character = " + character + ", cost = " + cost+", birthday = "+birthDate ;
    }



}