package tn.esprit.gestionzoo.exceptions;

// Custom exception class to handle invalid age
public class InvalidAgeException extends Exception {

    // Constructor that accepts a message
    public InvalidAgeException(String message) {
        super(message);
    }
}
