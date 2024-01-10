package ru.mts;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public void createAnimals(int number){
        Animal animal;
        for (int i = 1; i <number; i++) {
            animal = randomAnimal(i);
            System.out.println(i+")"+" "+animal);

        }
    }

    @Override
    public void createAnimals() {
        int i = 1;
        Animal animal;
        do {
            animal= randomAnimal(i);
            System.out.println(i+")"+" "+animal);

            i++;
        }while (i<11);
    }

    public void createAnimalsImpl(){
        CreateAnimalService.super.createAnimals();
    }


}
