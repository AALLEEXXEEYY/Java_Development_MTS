package mts.animals;


import java.math.BigDecimal;

public class Shark extends Predator {
    public Shark(String breed, String name, String character) {
        super(breed, name, character);
    }


    @Override
    public String getBread() {
        return breed;
    }

    @Override
    public BigDecimal getCost() {
        return null;
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