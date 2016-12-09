package ru.levnikolaevich.littlebrother.dao;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Repository;
import ru.levnikolaevich.littlebrother.model.Student;
import ru.levnikolaevich.littlebrother.model.StudentDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao implements IStudentDao {

    private MapperFactory mapperFactory;
    private EntityManagerFactory entityEntryFactory;
    private EntityManager entityManager;

    public StudentDao() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
      //  this.mapperFactory.classMap(Student.class, StudentDTO.class).register();

        entityEntryFactory = Persistence.createEntityManagerFactory( "brother_student" );
    }

    @Override
    public void addStudent(StudentDTO studentDto) {
        createEntityManager();
        
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDto, Student.class);
        entityManager.persist(student);
    }

    @Override
    public void udpateStudent(StudentDTO studentDto) {
        createEntityManager();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDto, Student.class);
        entityManager.merge(student);
    }

    @Override
    public void removeStudent(int id) {
        createEntityManager();
        Student student = entityManager.find(Student.class, new Integer(id));
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public StudentDTO getStudentById(int id) {
        createEntityManager();
        Student studentEntity = entityManager.find(Student.class, new Integer(id));
        MapperFacade mapper = mapperFactory.getMapperFacade();
        StudentDTO student = mapper.map(studentEntity, StudentDTO.class);
        return student;
    }

    @Override
    public List<StudentDTO> getStudentAll() {
        createEntityManager();
        List<StudentDTO> studentDTO = new ArrayList<>();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT std FROM Student std", Student.class);
        List<Student> list = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        if(list.size() > 0) {
            MapperFacade mapper = mapperFactory.getMapperFacade();
            studentDTO = mapper.mapAsList(list, StudentDTO.class);
        }
        return studentDTO;
    }

    private void createEntityManager(){
        entityManager  = entityEntryFactory.createEntityManager();
    }
}
