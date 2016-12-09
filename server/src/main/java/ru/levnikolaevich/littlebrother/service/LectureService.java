package ru.levnikolaevich.littlebrother.service;

import org.springframework.stereotype.Service;
import ru.levnikolaevich.littlebrother.dao.ILectureDao;
import ru.levnikolaevich.littlebrother.model.LectureDTO;

import java.util.List;

@Service
public class LectureService implements ILectureService {

    ILectureDao lectureDao;

    public LectureService() {
    }

    public void setLectureDao(ILectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @Override
    public void addLecture(LectureDTO lecture) {
        lectureDao.addLecture(lecture);
    }

    @Override
    public void udpateLecture(LectureDTO lecture) {
        lectureDao.udpateLecture(lecture);
    }

    @Override
    public void removeLecture(int id) {
        lectureDao.removeLecture(id);
    }

    @Override
    public LectureDTO getLectureById(int id) {
        return lectureDao.getLectureById(id);
    }

    @Override
    public List<LectureDTO> getLectureAll() {
        return lectureDao.getLectureAll();
    }
}
