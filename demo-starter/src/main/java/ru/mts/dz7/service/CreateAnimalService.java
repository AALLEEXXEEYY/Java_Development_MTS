package ru.mts.dz7.service;

import ru.mts.dz7.animals.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.round;

public interface CreateAnimalService {

    public Animal getRandomAnimal();

    public enum AnimalType{
        DOG,
        CAT,
        WOLF,
        SHARK;

        public AnimalType getTypeName() {
            return this;
        }

        public static int getCountEnumAnimals() {
            return values().length;
        }

    }

    default AnimalType getRandomAnimalType(){
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

    static Animal randomAnimal(AnimalType type){

        Animal animal = null;
        switch (type){
            case DOG:{
                animal = new Dog("Breed","DOG","Character", BigDecimal.valueOf(100));
                break;
            }
            case CAT:{
                animal = new Cat("Breed","CAT", "Character", BigDecimal.valueOf(100));
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
            default:
                throw new IllegalArgumentException("Неизвестный тип животного: " + type);
        }
        return animal;



    }

    /***
     * Функция реализована таким образом, чтобы создать HashMap который содержит рандомных животных в колличестве 5 шт
     *
     * @return
     * Словарь рандомных животных
     */

    default Map<String, List<Animal>> createAnimals(){
        Map<String, List<Animal>> result = new HashMap<>();
        for (int j = 0; j < 3; j++) {
            AnimalType animalType = getRandomAnimalType();
            List<Animal> animals = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                animals.add(randomAnimal(animalType));
            }
            result.put(animalType.getTypeName().toString(),animals);
        }
        return result;
    }

    /***
     * Функция реализована таким образом, чтобы создать HashMap который содержит все виды животных
     * @return
     * сдоварь содержащий всех животных enum-a
     */

    default Map<String, List<Animal>> myCreateAnimals(){
        Map<String, List<Animal>> result = new HashMap<>();

        while (AnimalType.getCountEnumAnimals() != result.size()){
            AnimalType animalType = getRandomAnimalType();
            List<Animal> animals = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                animals.add(randomAnimal(animalType));
            }
            result.put(animalType.getTypeName().toString(),animals);

        }

        return result;
    }

    default String getRandomName(String[] names){
        int n = (int)Math.floor(Math.random() * names.length);
        return names[n];
    }


}
