package ru.levnikolaevich.littlebrother.dao;

import org.junit.Assert;
import org.junit.Test;
import ru.levnikolaevich.littlebrother.model.LectureDTO;
import ru.levnikolaevich.littlebrother.model.StudentDTO;
import ru.levnikolaevich.littlebrother.service.LectureService;

import java.util.GregorianCalendar;
import java.util.List;

public class DaoFactoryTest {

    @Test
    public void testAddLecture() throws Exception {
        LectureService lectureService = new LectureService();

       // LectureDao lectureDao = new LectureDao();
        //lectureService.setLectureDao(lectureDao);

        List<LectureDTO> list = lectureService.getLectureAll();

        if(list == null)
        {
            LectureDTO lectureDTO = new LectureDTO();
            lectureDTO.setDateStart(new GregorianCalendar());
            lectureDTO.setTheme("Первая лекция ТЕСТ");
            lectureDTO.setVersion(1);
            lectureService.addLecture(lectureDTO);
            list = lectureService.getLectureAll();
        }

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testAddStudent() throws Exception {
        StudentDao studentDao = new StudentDao();
        List<StudentDTO> list = studentDao.getStudentAll();

        if(list.size() == 0)
        {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setFio("Первый студент");
            studentDTO.setSex(false);
            studentDTO.setGroup(100);
            studentDTO.setVersion(1);

            studentDao.addStudent(studentDTO);
        }

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetAllLecture() throws Exception {
        LectureDao lectureDao = new LectureDao();
        List<LectureDTO> list = lectureDao.getLectureAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetAllStudent() throws Exception {
        StudentDao studentDao = new StudentDao();
        List<StudentDTO> list = studentDao.getStudentAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }
}
