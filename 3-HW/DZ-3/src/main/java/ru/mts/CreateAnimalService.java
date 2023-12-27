package ru.mts;

import java.math.BigDecimal;

import static java.lang.Math.round;

public interface CreateAnimalService {

    default  void createAnimals(){
        int i = 0;
        while (i<10){
            Animal animal = randomAnimal(i);
            i++;
        }
    }

    default Animal randomAnimal(int i){

        switch ((int)(round(Math.random()*4) % 4)){
            case 0:{
                return new Dog((i+1)+") Breed","Dog", "Character", BigDecimal.valueOf(i*200));
            }
            case 1:{
                return new Cat((i+1)+") Breed","Cat","Character",BigDecimal.valueOf(i*100));
            }
            case 2:{
                return new Wolf((i+1)+") Breed","Wolf","Character");
            }
            case 3:{
                return new Shark((i+1)+") Breed","Shark","Character");
            }

        }
        return null;
    }

}
