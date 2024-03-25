package ru.mts.dz7.exeptions;

public class EmptyAnimalListException extends Exception{

    @Override
    public String getMessage() {
        return "Attention! List is empty and cannot calculate anything!";
    }
}
