package ru.mts.dz7demo.service.search;


import ru.mts.dz7demo.animals.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        List<String> names = new ArrayList<>();
        for (Animal animal:animals){
            if(animal.getBirthDate().isLeapYear()){
                names.add(animal.getName());
            };
        }
        String[] result = new String[names.size()];
        names.toArray(result);
        return result;
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, LocalDate dateForSearch) {
        List<Animal> names = new ArrayList<>();
        for (Animal animal:animals){
            if(animal.getBirthDate().isBefore(dateForSearch)){
                names.add(animal);
            }
        }
        Animal[] result = new Animal[names.size()];
        names.toArray(result);
        return result;
    }

    @Override
    public Animal[] findDublicate(Animal[] animals) {
        List<Animal> dublicates = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {
            for (int j = i+1; j < animals.length; j++) {
                if (animals[i].equals(animals[j])){
                    if (!dublicates.contains(animals[i]))
                        dublicates.add(animals[i]);
                }
            }
        }
        for(Animal animal:dublicates){
            System.out.println(animal.toString());
        }
        Animal[] dublicat=new Animal[dublicates.size()];
        dublicates.toArray(dublicat);
        return dublicat;
    }
}
