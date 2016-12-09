package ru.levnikolaevich.littlebrother.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levnikolaevich.littlebrother.dao.IStudentDao;
import ru.levnikolaevich.littlebrother.model.Student;
import ru.levnikolaevich.littlebrother.model.StudentDTO;

import java.util.List;

@Service
public class StudentService implements IStudentService {

   @Autowired
    IStudentDao studentDao;

    private MapperFactory mapperFactory;

    public StudentService() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDTO, Student.class);
        studentDao.save(student);
    }

    @Override
    public void udpateStudent(StudentDTO studentDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDTO, Student.class);
        studentDao.save(student);
    }

    @Override
    public void removeStudent(int id) {
        studentDao.delete(id);
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student student = studentDao.findOne(id);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getStudentAll() {
        Iterable<Student> list = studentDao.findAll();

        MapperFacade mapper = mapperFactory.getMapperFacade();
        List<StudentDTO> listDTO = mapper.mapAsList(list, StudentDTO.class);

        return listDTO;
    }
}
