package ru.levnikolaevich.littlebrother.service;

import ru.levnikolaevich.littlebrother.model.LectureDTO;

import java.io.Serializable;
import java.util.List;

public interface ILectureService extends Serializable {
    void addLecture(LectureDTO lectureDTO);
    void udpateLecture(LectureDTO lectureDTO);
    void removeLecture(int id);
    LectureDTO getLectureById(int id);
    List<LectureDTO> getLectureAll();
}
