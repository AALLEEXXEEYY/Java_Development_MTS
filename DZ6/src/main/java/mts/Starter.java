package mts;

import mts.animals.Animal;
import mts.service.AnimalRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Starter.class);
        AnimalRepository animalRepository = context.getBean(AnimalRepository.class);

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
