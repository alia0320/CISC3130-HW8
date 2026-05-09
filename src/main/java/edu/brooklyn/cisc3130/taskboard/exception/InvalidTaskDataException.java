package edu.brooklyn.cisc3130.taskboard.exception;

// probably handles 400 bad requests
public class InvalidTaskDataException extends RuntimeException {

    public InvalidTaskDataException(String message) {
        super(message);
    }
}