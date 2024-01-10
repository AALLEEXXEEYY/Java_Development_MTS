package ru.mts;

import java.math.BigDecimal;
import java.util.Random;

import static java.lang.Math.round;

public interface CreateAnimalService {


    public enum AnimalType{
        DOG,
        CAT,
        WOLF,
        SHARK
    }

    default AnimalType getRandomAnimalType(int i){
        switch ((int)(round(Math.random()*4) % 4)){
            case 0:{
                return AnimalType.WOLF;
            }
            case 1:{
                return AnimalType.CAT;
            }
            case 2:{
                return AnimalType.DOG;
            }
            case 3:{
                return AnimalType.SHARK;
            }
        }
        return AnimalType.CAT;
    }

    default  Animal[] createAnimals(){
        Animal[] animals = new Animal[100];
        int i = 1;
        while (i<101){
            animals[i] = randomAnimal(getRandomAnimalType(i));
            i++;
        }
        return animals;
    }

    default Animal randomAnimal(AnimalType type){
        Animal animal = null;
        switch (type){
            case DOG:{
                animal = new Dog("Breed","DOG","Character", BigDecimal.valueOf(new Random().nextInt(300)));
                break;
            }
            case CAT:{
                animal = new Cat("Breed","CAT", "Character", BigDecimal.valueOf(new Random().nextInt(200)));
                break;
            }
            case WOLF:{
                animal = new Wolf("Breed","WOLF","Character");
                break;
            }
            case SHARK:{
                animal = new Shark("Breed","SHARK","Character");
                break;
            }
        }
        return animal;
    }
}
