package ru.levnikolaevich.littlebrother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.levnikolaevich.littlebrother.exception.PersistException;
import ru.levnikolaevich.littlebrother.model.LectureDTO;
import ru.levnikolaevich.littlebrother.service.ILectureService;

import java.util.List;

@Controller
public class LectureController {

    @Autowired
    private ILectureService lectureService;

//    public void setLectureService(ILectureService lectureService) {
//        this.lectureService = lectureService;
//    }

    @RequestMapping("/lectures")
    public String getLecturesList(Model model) throws PersistException {
        List<LectureDTO> list = lectureService.getLectureAll();
        model.addAttribute("lectureList", list);
        return "lectures";
    }

    @RequestMapping(value = "/addLecture", method = RequestMethod.GET)
    public String addLecturePage(Model model) throws PersistException {

        return "addlecture";
    }

    @RequestMapping(value = "/addLecture", method = RequestMethod.POST)
    @ResponseBody
    public String addLecture() throws PersistException {

        return "getLecturesList";
    }

}
