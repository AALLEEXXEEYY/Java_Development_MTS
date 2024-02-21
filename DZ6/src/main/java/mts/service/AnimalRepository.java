package mts.service;

import mts.animals.Animal;

import java.util.Set;

public interface AnimalRepository {

    Animal[] printAllAnimals();
    String [] findLeapYearNames();
    Animal [] findOlderAnimal(int age);
    Set<Animal> findDuplicate();
    void printDublicate();





}
