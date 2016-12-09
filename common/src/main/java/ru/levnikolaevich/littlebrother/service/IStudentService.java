package ru.levnikolaevich.littlebrother.service;

import ru.levnikolaevich.littlebrother.model.StudentDTO;

import java.io.Serializable;
import java.util.List;

public interface IStudentService extends Serializable {
    void addStudent(StudentDTO studentDTO);
    void udpateStudent(StudentDTO studentDTO);
    void removeStudent(int id);
    StudentDTO getStudentById(int id);
    List<StudentDTO> getStudentAll();
}
