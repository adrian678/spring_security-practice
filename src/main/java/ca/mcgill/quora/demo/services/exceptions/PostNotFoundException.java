package ca.mcgill.quora.demo.services.exceptions;

public class PostNotFoundException extends Exception{

    public PostNotFoundException(String message){
        super(message);
    }
}
