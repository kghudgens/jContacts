package main.java;

/**
 * Class represents an exception that is raised when a method returns a null value.
 */
public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String message){
        super(message);
    }
}
