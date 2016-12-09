package ru.levnikolaevich.littlebrother.dao;

import ru.levnikolaevich.littlebrother.model.LectureDTO;

import java.util.List;

public interface ILectureDao {
    void addLecture(LectureDTO lectureDto);
    void udpateLecture(LectureDTO lectureDto);
    void removeLecture(int id);
    LectureDTO getLectureById(int id);
    List<LectureDTO> getLectureAll();
}
