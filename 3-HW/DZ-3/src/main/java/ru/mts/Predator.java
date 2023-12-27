package ru.mts;

public abstract class Predator extends AbstractAnimal {
    public Predator(String breed, String name, String character) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        cost = null;
    }
}
