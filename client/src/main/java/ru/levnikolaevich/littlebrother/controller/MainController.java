package ru.levnikolaevich.littlebrother.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.levnikolaevich.littlebrother.exception.PersistException;

import java.security.Principal;

/**
 * Created by innopolis on 25-Nov-16.
 */
@Controller
public class MainController {

//    @Autowired
//    StudentService studentService;
//
//    @Autowired
//    LectureService lectureService;

    //Spring Security see this :
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView main() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("home");
//        return model;
//    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            model.setViewName("login");
        } else {
            model.setViewName("home");
        }

        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView notPage() {

        ModelAndView model = new ModelAndView();

        model.setViewName("404");
        return model;
    }


    @RequestMapping("/home")
    public String getHome(Model model) throws PersistException {

        return "home";
    }

    @RequestMapping("/")
    public String getHomeFirst(Model model) throws PersistException {

        return "home";
    }
}
