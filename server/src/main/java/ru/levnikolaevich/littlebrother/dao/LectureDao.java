package ru.levnikolaevich.littlebrother.dao;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Repository;
import ru.levnikolaevich.littlebrother.model.Lecture;
import ru.levnikolaevich.littlebrother.model.LectureDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LectureDao implements ILectureDao {

    private MapperFactory mapperFactory;
    private EntityManagerFactory entityEntryFactory;
    private EntityManager entityManager;

    public LectureDao() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
      //  this.mapperFactory.classMap(Lecture.class, LectureDTO.class).register();

        this.entityEntryFactory = Persistence.createEntityManagerFactory( "brother_student" );
    }

    @Override
    public void addLecture(LectureDTO lectureDto) {
//        entityManager = entityEntryFactory.createEntityManager();
        createEntityManager();
        entityManager.getTransaction().begin();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Lecture lecture = mapper.map(lectureDto, Lecture.class);
        entityManager.persist(lecture);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void udpateLecture(LectureDTO lectureDto) {
        createEntityManager();

        MapperFacade mapper = mapperFactory.getMapperFacade();
        Lecture lecture = mapper.map(lectureDto, Lecture.class);
        entityManager.merge(lecture);
    }

    @Override
    public void removeLecture(int id) {
        createEntityManager();

        Lecture lecture = entityManager.find(Lecture.class, new Integer(id));
        if (lecture != null) {
            entityManager.remove(lecture);
        }
    }

    @Override
    public LectureDTO getLectureById(int id) {
        createEntityManager();

        Lecture lectureEntity = entityManager.find(Lecture.class, new Integer(id));
        MapperFacade mapper = mapperFactory.getMapperFacade();

        LectureDTO lecture = mapper.map(lectureEntity, LectureDTO.class);

        return lecture;
    }


    @Override
    public List<LectureDTO> getLectureAll() {
        createEntityManager();

        List<LectureDTO> listDTO =  new ArrayList<>();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT lec FROM Lecture lec", Lecture.class);
        List<Lecture> list = (List<Lecture>) query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        if(list.size() > 0){
            MapperFacade mapper = mapperFactory.getMapperFacade();
            listDTO = mapper.mapAsList(list, LectureDTO.class);
        }

        return listDTO;
    }

    private void createEntityManager(){
        entityManager  = entityEntryFactory.createEntityManager();
    }
}
