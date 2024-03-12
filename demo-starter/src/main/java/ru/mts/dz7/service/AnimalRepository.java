package ru.mts.dz7.service;


import ru.mts.dz7.animals.Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    List<Animal> printAllAnimals();
    Map<String, LocalDate> findLeapYearNames();
    Map<Animal,Integer> findOlderAnimal(int age);
    Map<String,Integer> findDuplicate();
    void printDuplicate();





}
