package ru.mts;

import java.math.BigDecimal;

public class Cat extends Pet{

    public Cat(String breed, String name, String character, BigDecimal cost) {
        super(breed, name, character, cost);

    }

    @Override
    public String getBread() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }
}