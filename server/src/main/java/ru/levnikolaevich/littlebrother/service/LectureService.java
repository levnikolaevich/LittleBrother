package ru.levnikolaevich.littlebrother.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levnikolaevich.littlebrother.dao.ILectureDao;
import ru.levnikolaevich.littlebrother.model.Lecture;
import ru.levnikolaevich.littlebrother.model.LectureDTO;

import java.util.List;

@Service
public class LectureService implements ILectureService {

    @Autowired
    ILectureDao lectureDao;

    private Logger logger = LoggerFactory.getLogger(LectureService.class);

    private MapperFactory mapperFactory;

    public LectureService() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @Override
    public void addLecture(LectureDTO lectureDTO) {

        MapperFacade mapper = mapperFactory.getMapperFacade();
        Lecture lecture = mapper.map(lectureDTO, Lecture.class);

        lectureDao.save(lecture);
    }

    @Override
    public void udpateLecture(LectureDTO lectureDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Lecture lecture = mapper.map(lectureDTO, Lecture.class);
        lectureDao.save(lecture);
    }

    @Override
    public void removeLecture(int id) {
        lectureDao.delete(id);
    }

    @Override
    public LectureDTO getLectureById(int id) {
        Lecture lecture = lectureDao.findOne(id);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        LectureDTO lectureDTO = mapper.map(lecture, LectureDTO.class);
        return lectureDTO;
    }

    @Override
    public List<LectureDTO> getLectureAll() {
        Iterable<Lecture> list = lectureDao.findAll();

        MapperFacade mapper = mapperFactory.getMapperFacade();
        List<LectureDTO> listDTO = mapper.mapAsList(list, LectureDTO.class);

        return listDTO;
    }
}
