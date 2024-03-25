package ru.mts.dz7.service;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;
import ru.mts.dz7.animals.AbstractAnimal;
import ru.mts.dz7.animals.Animal;
import ru.mts.dz7.exeptions.CustomException;
import ru.mts.dz7.exeptions.CustomIllegalArgumentException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Map.Entry;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository{

    private AbstractAnimal abstractAnimal;

    CreateAnimalService animalService;

    public List<Animal> animals= new ArrayList<>();
    public List<Animal> getAnimals() {
        return animals;
    }

    @Lookup
    public CreateAnimalService getCreateAnimalService() {
        return null;
    }

    @PostConstruct
    public void createAnimals(){
        for (int i = 0; i < 100 ; i++) {
            CreateAnimalService createAnimalService = getCreateAnimalService();
            animals.add(createAnimalService.getRandomAnimal());
        }
    }

    @Override
    public List<Animal> printAllAnimals() throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        for (int i=0;i<animals.size();i++){
            System.out.println(i+1+") "+ animals.get(i));
        }
        return animals;
    }

//    @Override
//    public Map<String, LocalDate> findLeapYearNames() {
//        Map<String, LocalDate> result = new HashMap<>();
//        for (Animal animal:animals){
//            if(animal.getBirthDate().isLeapYear()){
//                result.put(animal.getName(),animal.getBirthDate());
//            };
//        }
//        return result;
//    }

    @Override
    public Map<String, LocalDate> findLeapYearNames()throws CustomException{
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        return animals.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(animal -> animal.toString()+" "+animal.getName(),Animal::getBirthDate));

    }

//    @Override
//    public Map<Animal,Integer> findOlderAnimal(int age) {
//        Map<Animal,Integer> animalIntegerMap = new HashMap<>();
//        int maxlifeAge = 0;
//        Animal animalwithMaxAge = null;
//        for (Animal animal:animals){
//            int lifeAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
//            if(lifeAge>=age){
//                animalIntegerMap.put(animal,lifeAge);
//                continue;
//            };
//            if(lifeAge>=maxlifeAge){
//                animalwithMaxAge = animal;
//                maxlifeAge = lifeAge;
//            }
//        }
//        if (animalIntegerMap.isEmpty()){
//            animalIntegerMap.put(animalwithMaxAge,maxlifeAge);
//        }
//
//        return animalIntegerMap;
//    }


    @Override
    public Map<Animal,Integer> findOlderAnimal(int age) throws CustomException, CustomIllegalArgumentException {
        if (age<=0){
            throw new CustomIllegalArgumentException(age);
        }
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        Map<Animal, Integer> findedanimals = animals.stream()
                .filter(animal -> (Period.between(animal.getBirthDate(), LocalDate.now()).getYears()) > age)
                .collect(Collectors.toMap(animal->animal,animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()));
        if (findedanimals.isEmpty()){
            Animal animal= animals.stream()
                    .min(Comparator.comparing(Animal::getBirthDate))
                    .get();
            findedanimals.put(animal,Period.between(animal.getBirthDate(), LocalDate.now()).getYears());
        };
        return findedanimals;
    }



//    @Override
//    public Map<String,Integer> findDuplicate() {
//        Set<Animal> set = new HashSet<>();
//        Map<String,Integer> dublicates = new HashMap<>();
//        for (Animal animal : animals) {
//            if (!set.add(animal)) {
//                if (dublicates.containsKey(animal.toString())) {
//                    Integer count = dublicates.get(animal.toString());
//                    dublicates.replace(animal.toString(), ++count);
//                } else {
//                    dublicates.put(animal.toString(), 1);
//                }
//            }
//
//        }
//        return dublicates;
//    }

    @Override
    public Map<String, List<Animal>> findDuplicate() throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }

        return animals.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        Map.Entry::getValue));
    }


    @Override
    public void printDuplicate() throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        Map<String, List<Animal>> duplicates = findDuplicate();
        for(Map.Entry<String, List<Animal>> keyValue:duplicates.entrySet()){
            System.out.println(keyValue.getKey()+":"+keyValue.getValue());
        }
    }


    @Override
    public double findAverageAge() throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        return animals.stream()
                .mapToInt(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears())
                .average()
                .orElseThrow(() -> new RuntimeException("Could not calculate average age"));
    }

    @Override
    public List<Animal> findOldAndExpensive() throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }

        BigDecimal averagePrice = animals.stream()
                .map(Animal::getCost)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(animals.size()), 2, BigDecimal.ROUND_HALF_UP);

        return animals.stream()
                .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()>5)
                .filter(animal -> animal.getCost() != null && animal.getCost().compareTo(averagePrice) > 0)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findMinConstAnimals()throws CustomException {
        if (animals.isEmpty()){
            throw new CustomException(0);
        }
        return animals.stream()
                .filter(animal -> Objects.nonNull(animal.getCost()))
                .sorted(Comparator.comparing((Animal animal) -> animal.getCost()).reversed())
                .map(Animal::getName)
                .limit(3)
                .collect(Collectors.toList());

    }
}
