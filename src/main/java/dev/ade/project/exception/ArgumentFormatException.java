package dev.ade.project.exception;

public class ArgumentFormatException extends Exception {

    public ArgumentFormatException(){}

    public ArgumentFormatException(String message){
        super(message);
    }

    public ArgumentFormatException(String message, Exception e){
        super(message, e);
    }
}
