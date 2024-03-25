package ru.mts.dz7.service;


import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.exeptions.CustomException;
import ru.mts.dz7.exeptions.CustomIllegalArgumentException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    List<Animal> printAllAnimals() throws CustomException;
    Map<String, LocalDate> findLeapYearNames() throws CustomException;
    Map<Animal,Integer> findOlderAnimal(int age) throws CustomException, CustomIllegalArgumentException;
    Map<String,List<Animal>> findDuplicate() throws CustomException;
    void printDuplicate() throws CustomException;
    double findAverageAge() throws CustomException;
    List<Animal> findOldAndExpensive() throws CustomException;
    List<String> findMinConstAnimals() throws CustomException;






}
