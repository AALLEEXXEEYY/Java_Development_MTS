package mts;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public Animal[] createAnimals(int number){
        Animal[] animals = new Animal[100];
        for (int i = 0; i <number; i++) {
            animals[i] = randomAnimal(getRandomAnimalType(i));
        }
        return animals;
    }

    @Override
    public Animal[] createAnimals() {
        int i = 1;
        Animal[] animals = new Animal[100];
        do {
            animals[i] = randomAnimal(getRandomAnimalType(i));
            i++;
        }while (i<101);
        return animals;
    }

    public Animal[] createAnimalsImpl(){
        return CreateAnimalService.super.createAnimals();
    }


}
