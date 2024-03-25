package ru.mts.dz7.exeptions;

public class CustomIllegalArgumentException extends IllegalArgumentException{
    private final int argumentCausedException;
    public CustomIllegalArgumentException(int argument){
        this.argumentCausedException = argument;
    }

    @Override
    public String getMessage() {
        return "n must be > "+argumentCausedException;
    }
}
