package ru.levnikolaevich.littlebrother.dao;

import org.springframework.data.repository.CrudRepository;
import ru.levnikolaevich.littlebrother.model.Lecture;


public interface ILectureDao extends CrudRepository<Lecture, Integer> {

}
