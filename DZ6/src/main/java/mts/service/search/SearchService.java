package mts.service.search;

import mts.animals.Animal;

import java.time.LocalDate;

public interface SearchService {

    public String[] findLeapYearNames(Animal[] animals);
    public Animal[] findOlderAnimal(Animal[] animals, LocalDate dateForSearch);
    public Animal[] findDublicate(Animal[] animals);
}
