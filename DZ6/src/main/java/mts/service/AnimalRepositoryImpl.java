package mts.service;

import mts.animals.Animal;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Repository
public class AnimalRepositoryImpl implements AnimalRepository{

    Animal[] animals;

    @Lookup
    public CreateAnimalService getCreateAnimalService() {
        return null;
    }

    public AnimalRepositoryImpl(){
        animals = new Animal[100];
    }

    @PostConstruct
    public void createAnimals(){
        for (int i = 0; i < animals.length ; i++) {
            CreateAnimalService createAnimalService = getCreateAnimalService();
            animals[i] = createAnimalService.getRandomAnimal();
        }
    }
    @Override
    public Animal[] printAllAnimals(){
        for (int i=0;i<animals.length;i++){
            System.out.println(i+1+") "+animals[i]);
        }
        return animals;
    }

    @Override
    public String[] findLeapYearNames() {
        List<String> list=new ArrayList<>();
        for(Animal animal : animals){
            if(animal.getBirthDate().isLeapYear()){
                list.add(animal.toString());
            }

        }
        String[] animalstring= new String[list.size()];
        list.toArray(animalstring);
        return animalstring;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    @Override
    public Animal[] findOlderAnimal(int age) {
        LocalDate controlDate= LocalDate.now().minusYears(age);

        List<Animal> list= Stream.of(getAnimals()).filter(a ->controlDate.isAfter(a.getBirthDate())).collect(Collectors.toList());
        Animal [] result=new Animal[list.size()];
        return list.toArray(result);
    }


    public Set<Animal> findDuplicate() {
        List<Animal> dublicates = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {
            for (int j = i+1; j < animals.length; j++) {
                if (animals[i].equals(animals[j])){
                    if (!dublicates.contains(animals[i]))
                        dublicates.add(animals[i]);
                }
            }
        }

        Set<Animal> mySet = new HashSet<>(dublicates);

        return mySet;
    }


    @Override
    public void printDublicate() {
        Set<Animal> mySet=findDuplicate();

        for(Animal animal: mySet){
            System.out.println(animal);

        }

    }
}
