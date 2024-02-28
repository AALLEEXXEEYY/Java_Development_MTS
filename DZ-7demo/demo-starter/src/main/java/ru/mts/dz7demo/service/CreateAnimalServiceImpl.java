package ru.mts.dz7demo.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.dz7demo.animals.*;
import ru.mts.dz7demo.config.CreateServiceProperties;

import java.util.Random;


public class CreateAnimalServiceImpl implements CreateAnimalService {

    AnimalType type;

    private CreateServiceProperties properties;

    public CreateAnimalServiceImpl(CreateServiceProperties properties) {
        this.properties = properties;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getRandomName(String[] names){
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    };

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



//    public Animal[] createAnimals(int number){
//        Animal[] animals = new Animal[100];
//        for (int i = 0; i <number; i++) {
//            animals[i] = randomAnimal(getRandomAnimalType(i));
//        }
//        return animals;
//    }

//    @Override
//    public Animal[] createAnimals() {
//        int i = 0;
//        Animal[] animals = new Animal[100];
//        do {
//            animals[i] = randomAnimal(getRandomAnimalType(i));
//            i++;
//        }while (i<101);
//        return animals;
//    }

//    public Animal[] createAnimalsImpl(){
//        return CreateAnimalService.super.createAnimals();
//    }


}
