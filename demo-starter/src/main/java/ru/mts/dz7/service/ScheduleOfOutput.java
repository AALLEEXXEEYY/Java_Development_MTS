package ru.mts.dz7.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.exeptions.CustomException;
import ru.mts.dz7.exeptions.CustomIllegalArgumentException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ScheduleOfOutput {


    @Autowired
    AnimalRepository animalsRepository;

    @Scheduled(fixedRate = 60000)
//    @PostConstruct
    public void Schedule(){
        try {


            System.out.println("Print all animals");
            System.out.println();
            List<Animal> allAnimals = animalsRepository.printAllAnimals();
            System.out.println();

            System.out.println("Search for Leap Year animals");
            System.out.println();
            Map<String, LocalDate> names = animalsRepository.findLeapYearNames();
            for (Map.Entry<String, LocalDate> keyValue : names.entrySet()) {
                System.out.println(keyValue.getKey() + " : " + keyValue.getValue());
            }
            System.out.println();

            System.out.println("Search older animals");
            System.out.println();
            Map<Animal, Integer> animals = animalsRepository.findOlderAnimal(3);
            for (Map.Entry<Animal, Integer> animal : animals.entrySet()) {
                System.out.println("Animal name:" + animal.getKey().getName() + ", How many age:" + animal.getValue());
            }
            System.out.println();

            System.out.println("Print duplicates");
            System.out.println();
            animalsRepository.printDuplicate();

            System.out.println();


            System.out.println("Find average age animals:");
            System.out.println();
            System.out.println("Average age animals: " + animalsRepository.findAverageAge());
            System.out.println();


            System.out.println("Find Older and expensive animals: ");
            System.out.println();
            System.out.println(animalsRepository.findOldAndExpensive());
            System.out.println();

            System.out.println("Find min const animals:");
            System.out.println();
            System.out.println(animalsRepository.findMinConstAnimals());
        }

        catch (CustomException e) {
            System.out.println(e.getMessage());

        }
        catch (CustomIllegalArgumentException e){
            System.out.println(e.getMessage());
        }



    }



}
