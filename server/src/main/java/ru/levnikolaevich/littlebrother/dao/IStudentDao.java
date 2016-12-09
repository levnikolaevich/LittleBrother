package ru.levnikolaevich.littlebrother.dao;

import org.springframework.data.repository.CrudRepository;
import ru.levnikolaevich.littlebrother.model.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {

}



