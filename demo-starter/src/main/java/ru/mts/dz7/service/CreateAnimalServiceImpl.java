package ru.mts.dz7.service;


import org.springframework.stereotype.Service;
import ru.mts.dz7.animals.*;
import ru.mts.dz7.config.CreateServiceProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CreateAnimalServiceImpl implements CreateAnimalService {

    AnimalType type;

    public AnimalType getType() {
        return type;
    }

    private CreateServiceProperties properties;

    public CreateAnimalServiceImpl(CreateServiceProperties properties) {
        this.properties = properties;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }


    public Animal getRandomAnimal(){
        Animal animal =CreateAnimalService.randomAnimal(type);
        if (animal instanceof Cat){
            ((Cat) animal).setName(getRandomName(properties.getCatName()));
        }
        if (animal instanceof Dog){
            ((Dog) animal).setName(getRandomName(properties.getDogName()));
        }
        if (animal instanceof Wolf){
            ((Wolf) animal).setName(getRandomName(properties.getWolfName()));
        }
        if (animal instanceof Shark){
            ((Shark) animal).setName(getRandomName(properties.getSharkName()));
        }

        return animal;
    }

    public BigDecimal getCatCost(){
        Cat cat=new Cat("Breed","CAT", "Character", BigDecimal.valueOf(100));
        return cat.getCost();

    }
    public BigDecimal getDogCost(){
        Dog dog=new Dog("Breed","DOG","Character", BigDecimal.valueOf(100));
        return dog.getCost();

    }

    public BigDecimal getSharkCost(){
        Shark shark=new Shark("Breed","SHARK","Character");
        return shark.getCost();

    }

    public BigDecimal getWolfCost(){
        Wolf wolf= new Wolf("Breed","WOLF","Character");
        return wolf.getCost();

    }

    @Override
    public Map<String, List<Animal>> createAnimals() {
        var result = new ConcurrentHashMap<String,List<Animal>>();
        for (int i = 0; i < 5; i++) {
            int j = 0;
            AnimalType animalType = getRandomAnimalType();
            List<Animal> animals = new CopyOnWriteArrayList<>();
            do {
                animals.add(CreateAnimalService.randomAnimal(animalType));
                j++;
            }while (j<3);
            result.put(animalType.getTypeName().toString(),animals);
        }
        return result;
    }

    public Map<String, List<Animal>> createAnimals(int number){
        var result = new ConcurrentHashMap<String,List<Animal>>();
        for (int i = 0; i < number; i++) {
            AnimalType animalType = getRandomAnimalType();
            List<Animal> animals;
            if(result.containsKey(animalType.getTypeName())){
                animals= result.get(animalType.getTypeName());
            }
            else {
                animals = new CopyOnWriteArrayList<>();
                result.put(animalType.getTypeName().toString(),animals);
            }
            animals.add(CreateAnimalService.randomAnimal(animalType));

        }
        return result;
    }

    public Map<String, List<Animal>> createAnimalsImpl(){
        return CreateAnimalService.super.createAnimals();
    }




}
