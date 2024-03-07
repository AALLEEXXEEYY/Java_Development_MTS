package ru.mts.dz7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mts.dz7.animals.Animal;
import java.util.Set;


public class ScheduleOfOutput {


    @Autowired
    public AnimalRepository animalRepository;

    @Scheduled(fixedRate = 60000)
//    @PostConstruct
    public void Schedule(){
        System.out.println("Print all animals");
        Animal[] animalss=animalRepository.printAllAnimals();


        System.out.println("Search for Leap Year animals");
        String[] names = animalRepository.findLeapYearNames();
        for(String str:names){
            System.out.println(str);
        }


        System.out.println("Search old animals");
        Animal[] animals = animalRepository.findOlderAnimal(2);
        for(Animal animal: animals){
            System.out.println("Animal:"+animal.getName()+", Date of birth:"+animal.getBirthDate());
        }


        System.out.println("Find duplicates");
        Set<Animal> animalsDuplicate = animalRepository.findDuplicate();
        for(Animal animal: animalsDuplicate){
            System.out.println("Animal:"+animal.getName()+", Date of birth: "+animal.getBirthDate());
        }


        System.out.println("Print duplicates");
        animalRepository.printDublicate();


    }



}
