package edu.brooklyn.cisc3130.taskboard.validation;

import edu.brooklyn.cisc3130.taskboard.model.Task;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PriorityValidator implements ConstraintValidator<ValidPriority, String> {

    private static final Set<String> VALID_PRIORITIES =
            Arrays.stream(Task.Priority.values())
                    .map(Enum::name)
                    .collect(Collectors.toSet());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // Allow nulls here (usually handled by @NotNull if needed)
        if (value == null) {
            return true;
        }

        return VALID_PRIORITIES.contains(value.toUpperCase());
    }
}