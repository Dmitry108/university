package ru.home.aglar.university.converters;

import org.springframework.stereotype.Component;
import ru.home.aglar.university.dto.StudentDto;
import ru.home.aglar.university.entities.Student;

@Component
public class StudentConverter {
    public Student convertFromDto(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getName(), studentDto.getAge());
    }

    public StudentDto convertToDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getAge());
    }
}