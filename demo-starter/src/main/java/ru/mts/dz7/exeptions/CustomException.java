package ru.mts.dz7.exeptions;

public class CustomException extends Exception{
    private final int sizeArray;
    public CustomException(int argument){
        this.sizeArray = argument;
    }

    @Override
    public String getMessage() {
        return "List size should be > "+sizeArray;
    }
}
