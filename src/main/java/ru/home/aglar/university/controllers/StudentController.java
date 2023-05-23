package ru.home.aglar.university.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.home.aglar.university.converters.StudentConverter;
import ru.home.aglar.university.dto.StudentDto;
import ru.home.aglar.university.exeptions.ResourceNotFoundException;
import ru.home.aglar.university.servers.StudentService;
import ru.home.aglar.university.validators.StudentValidator;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentConverter studentConverter;
    private final StudentValidator studentValidator;

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentConverter.convertToDto(studentService.getStudentById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Product with id = %d does not found", id))));
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream().map(studentConverter::convertToDto).toList();
    }

    @PostMapping
    public StudentDto addNewStudent(@RequestBody StudentDto studentDto) {
        studentValidator.validate(studentDto);
        return studentConverter.convertToDto(studentService.addStudent(studentConverter.convertFromDto(studentDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentValidator.validate(studentDto);
        studentService.updateStudent(studentConverter.convertFromDto(studentDto));
    }
}