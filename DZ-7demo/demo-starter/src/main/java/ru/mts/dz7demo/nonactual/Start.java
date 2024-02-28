package ru.mts.dz7demo.nonactual;


import ru.mts.dz7demo.animals.Animal;
import ru.mts.dz7demo.service.CreateAnimalServiceImpl;
import ru.mts.dz7demo.service.search.SearchServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;

public class Start {
//    public static void main(String[] args) {
//        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();
//
//        Animal[] animals =animalService.createAnimals(100);
//        System.out.println("Весь список животных:");
//
//        for (Animal animal:animals)
//            System.out.println(animal.toString());
//
//        System.out.println("Животные подившиеся в високосном году:");
//        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
//        System.out.println(Arrays.toString(searchServiceImpl.findLeapYearNames(animals)));
//
//        System.out.println("Самые старшие животные:");
//        Animal[] olderAnimal = searchServiceImpl.findOlderAnimal(animals, LocalDate.now().minusYears(1));
//        for (Animal animal:olderAnimal){
//            System.out.println(animal);
//        }
//
//        System.out.println("Дубликаты животных:");
//        searchServiceImpl.findDublicate(animals);
//    }

}