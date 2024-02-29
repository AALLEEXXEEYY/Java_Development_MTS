package ru.mts.dz7.service;


import ru.mts.dz7.animals.*;
import ru.mts.dz7.config.CreateServiceProperties;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    AnimalType type;

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



}
