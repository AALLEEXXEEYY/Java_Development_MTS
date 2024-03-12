package ru.mts.dz7.service;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;
import ru.mts.dz7.animals.AbstractAnimal;
import ru.mts.dz7.animals.Animal;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Repository
public class AnimalRepositoryImpl implements AnimalRepository{

    private AbstractAnimal abstractAnimal;

    public List<Animal> animals= new ArrayList<>();
    public List<Animal> getAnimals() {
        return animals;
    }

    @Lookup
    public CreateAnimalService getCreateAnimalService() {
        return null;
    }

    @PostConstruct
    public void createAnimals(){
        for (int i = 0; i < 100 ; i++) {
            CreateAnimalService createAnimalService = getCreateAnimalService();
            animals.add(createAnimalService.getRandomAnimal());
        }
    }

    @Override
    public List<Animal> printAllAnimals(){
        for (int i=0;i<animals.size();i++){
            System.out.println(i+1+") "+ animals.get(i));
        }
        return animals;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> result = new HashMap<>();
        for (Animal animal:animals){
            if(animal.getBirthDate().isLeapYear()){
                result.put(animal.getName(),animal.getBirthDate());
            };
        }
        return result;
    }

    @Override
    public Map<Animal,Integer> findOlderAnimal(int age) {
        Map<Animal,Integer> animalIntegerMap = new HashMap<>();
        int maxlifeAge = 0;
        Animal animalwithMaxAge = null;
        for (Animal animal:animals){
            int lifeAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            if(lifeAge>=age){
                animalIntegerMap.put(animal,lifeAge);
                continue;
            };
            if(lifeAge>=maxlifeAge){
                animalwithMaxAge = animal;
                maxlifeAge = lifeAge;
            }
        }
        if (animalIntegerMap.isEmpty()){
            animalIntegerMap.put(animalwithMaxAge,maxlifeAge);
        }

        return animalIntegerMap;
    }


    @Override
    public Map<String,Integer> findDuplicate() {
        Set<Animal> set = new HashSet<>();
        Map<String,Integer> dublicates = new HashMap<>();
        for (Animal animal : animals) {
            if (!set.add(animal)) {
                if (dublicates.containsKey(animal.toString())) {
                    Integer count = dublicates.get(animal.toString());
                    dublicates.replace(animal.toString(), ++count);
                } else {
                    dublicates.put(animal.toString(), 1);
                }
            }

        }
        return dublicates;
    }

    @Override
    public void printDuplicate() {
        Map<String,Integer> duplicates = findDuplicate();
        for(Map.Entry<String,Integer> keyValue:duplicates.entrySet()){
            System.out.println(keyValue.getKey()+":"+keyValue.getValue());
        }
    }
}
