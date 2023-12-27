package ru.mts;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public void createAnimals(int number){
        Animal animal;
        for (int i = 0; i <number; i++) {
            animal = randomAnimal(i);

        }
    }

    @Override
    public void createAnimals() {
        int i = 0;
        Animal animal;
        do {
            animal= randomAnimal(i);

            i++;
        }while (i<10);
    }

    public void createAnimalsImpl(){
        CreateAnimalService.super.createAnimals();
    }


}
