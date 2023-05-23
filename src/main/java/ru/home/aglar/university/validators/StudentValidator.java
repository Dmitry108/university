package ru.home.aglar.university.validators;

import org.springframework.stereotype.Component;
import ru.home.aglar.university.dto.StudentDto;
import ru.home.aglar.university.exeptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentValidator {
    public void validate(StudentDto studentDto) {
        List<String> errors = new ArrayList<>();
        String name = studentDto.getName();
        Integer age = studentDto.getAge();
        if (name == null || name.isBlank()) {
            errors.add("name is absent");
        }
        if (age <= 0) {
            errors.add("price can't be negative or equals zero");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
