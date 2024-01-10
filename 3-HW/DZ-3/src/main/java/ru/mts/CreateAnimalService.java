package ru.mts;

import java.math.BigDecimal;

import static java.lang.Math.round;

public interface CreateAnimalService {

    default  void createAnimals(){
        int i = 1;
        while (i<11){
            Animal animal = randomAnimal(i);
            System.out.println(i+")"+" "+animal);
            i++;
        }
    }

    default  Animal randomAnimal(int i){

        switch ((int)(round(Math.random()*2) % 4)){
            case 0:{
                return new Dog(" Breed","Dog", "Character", BigDecimal.valueOf(i*200));
            }git 
            case 1:{
                return new Cat(" Breed","Cat","Character",BigDecimal.valueOf(i*100));
            }
            case 2:{
                return new Wolf(" Breed","Wolf","Character");
            }
            case 3:{
                return new Shark(" Breed","Shark","Character");
            }

        }
         return null;
    }

}
