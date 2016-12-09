package ru.levnikolaevich.littlebrother.service;

import org.springframework.stereotype.Service;
import ru.levnikolaevich.littlebrother.dao.IStudentDao;
import ru.levnikolaevich.littlebrother.model.StudentDTO;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    IStudentDao studentDao;

    public StudentService() {
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        studentDao.addStudent(studentDTO);
    }

    @Override
    public void udpateStudent(StudentDTO studentDTO) {
        studentDao.udpateStudent(studentDTO);
    }

    @Override
    public void removeStudent(int id) {
        studentDao.removeStudent(id);
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<StudentDTO> getStudentAll() {
        return studentDao.getStudentAll();
    }
}
