package ru.mts;


import java.math.BigDecimal;

public class Shark extends Predator {
    public Shark(String breed, String name, String character) {
        super(breed, name, character);
        System.out.print(breed+", ");
        System.out.print(name+", ");
        System.out.println(character);
    }


    @Override
    public String getBread() {
        return breed;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getCharacter() {
        return character;
    }


}