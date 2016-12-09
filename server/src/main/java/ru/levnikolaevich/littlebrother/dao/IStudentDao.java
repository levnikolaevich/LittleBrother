package ru.levnikolaevich.littlebrother.dao;

import ru.levnikolaevich.littlebrother.model.StudentDTO;

import java.util.List;

public interface IStudentDao {
    void addStudent(StudentDTO studentDto);
    void udpateStudent(StudentDTO studentDto);
    void removeStudent(int id);
    StudentDTO getStudentById(int id);
    List<StudentDTO> getStudentAll();
}
