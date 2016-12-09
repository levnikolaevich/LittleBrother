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
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDto, Student.class);
        entityManager.persist(student);
    }

    @Override
    public void udpateStudent(StudentDTO studentDto) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Student student = mapper.map(studentDto, Student.class);
        entityManager.merge(student);
    }

    @Override
    public void removeStudent(int id) {
        Student student = entityManager.find(Student.class, new Integer(id));
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student studentEntity = entityManager.find(Student.class, new Integer(id));
        MapperFacade mapper = mapperFactory.getMapperFacade();
        StudentDTO student = mapper.map(studentEntity, StudentDTO.class);
        return student;
    }

    @Override
    public List<StudentDTO> getStudentAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT std FROM Student std", Student.class);
        List<Student> list = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();


//        TypedQuery<Student> namedQuery = entityManager.createNamedQuery("Students.getAll", Student.class);
//        List<Student> list = namedQuery.getResultList();


        MapperFacade mapper = mapperFactory.getMapperFacade();
        List<StudentDTO> studentDTO = mapper.mapAsList(list, StudentDTO.class);

        return studentDTO;
    }

    private void createEntityManager(){
        entityManager  = entityEntryFactory.createEntityManager();
    }
}
