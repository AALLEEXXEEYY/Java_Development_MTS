package mts.animals;

import java.math.BigDecimal;

public class Wolf extends Predator {

    public Wolf(String breed, String name, String character) {
        super(breed, name, character);
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
        return null;
    }

    @Override
    public String getCharacter() {
        return character;
    }

}
