package ru.levnikolaevich.littlebrother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.levnikolaevich.littlebrother.exception.PersistException;
import ru.levnikolaevich.littlebrother.model.StudentDTO;
import ru.levnikolaevich.littlebrother.service.IStudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @RequestMapping("/students")
    public String getStudentsList(Model model) throws PersistException {
        List<StudentDTO> list = studentService.getStudentAll();
        model.addAttribute("stdlist", list);
        return "students";
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentPage() throws PersistException {

        return "addstudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam("fio") String fio, @RequestParam("sex") boolean sex, @RequestParam("group") int group) throws PersistException {
        StudentDTO student = new StudentDTO();
        student.setFio(fio);
        student.setSex(sex);
        student.setGroup(group);

        studentService.addStudent(student);

        return "redirect:/students";
    }

}
