package ru.mts;

import java.time.LocalDate;

public interface SearchService {

    public String[] findLeapYearNames(Animal[] animals);
    public Animal[] findOlderAnimal(Animal[] animals, LocalDate dateForSearch);
    public void findDublicate(Animal[] animals);
}
