package mts.service;

import mts.animals.Animal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    AnimalType type;

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Animal getRandomAnimal() {
        AnimalType type =getRandomAnimalType((int)(Math.random() * 4));
        return randomAnimal(type);

    }

    public Animal[] createAnimals(int number){
        Animal[] animals = new Animal[100];
        for (int i = 0; i <number; i++) {
            animals[i] = randomAnimal(getRandomAnimalType(i));
        }
        return animals;
    }

//    @Override
//    public Animal[] createAnimals() {
//        int i = 0;
//        Animal[] animals = new Animal[100];
//        do {
//            animals[i] = randomAnimal(getRandomAnimalType(i));
//            i++;
//        }while (i<101);
//        return animals;
//    }

//    public Animal[] createAnimalsImpl(){
//        return CreateAnimalService.super.createAnimals();
//    }


}
