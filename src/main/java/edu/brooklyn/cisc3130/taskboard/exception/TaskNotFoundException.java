package edu.brooklyn.cisc3130.taskboard.exception;

// probably handling 404 error codes
public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Integer id) {
        super("Task with ID " + id + " not found");
    }
}