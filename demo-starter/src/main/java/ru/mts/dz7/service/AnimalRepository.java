package ru.mts.dz7.service;


import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.exeptions.EmptyAnimalListException;
import ru.mts.dz7.exeptions.CustomIllegalArgumentException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    List<Animal> printAllAnimals() throws EmptyAnimalListException;
    Map<String, LocalDate> findLeapYearNames() throws EmptyAnimalListException;
    Map<Animal,Integer> findOlderAnimal(int age) throws EmptyAnimalListException, CustomIllegalArgumentException;
    Map<String,List<Animal>> findDuplicate() throws EmptyAnimalListException;
    void printDuplicate() throws EmptyAnimalListException;
    double findAverageAge() throws EmptyAnimalListException;
    List<Animal> findOldAndExpensive() throws EmptyAnimalListException;
    List<String> findMinConstAnimals() throws EmptyAnimalListException;






}
