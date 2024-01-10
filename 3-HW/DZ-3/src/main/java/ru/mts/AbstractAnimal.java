package ru.mts;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    @Override
    public String toString() {
        return "Dog: breed = " + breed + ", name = " + name + ", character = " + character + ", cost = " + cost;
    }
}
