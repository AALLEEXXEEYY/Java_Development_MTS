package ru.mts.dz7demo.service;


import ru.mts.dz7demo.animals.Animal;

import java.util.Set;

public interface AnimalRepository {

    Animal[] printAllAnimals();
    String [] findLeapYearNames();
    Animal [] findOlderAnimal(int age);
    Set<Animal> findDuplicate();
    void printDublicate();





}
