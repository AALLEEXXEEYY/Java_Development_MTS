package ru.mts;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();

        animalService.createAnimals();

        animalService.createAnimals(10);

        animalService.createAnimalsImpl();
    }
}