package controller;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.PersonService;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:10:07 AM
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("hello")
    public ModelAndView Hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello UserController");
        modelAndView.setViewName("hello");
        System.out.println("in hello modelandview");
        return modelAndView;
    }

    @RequestMapping("show")
    public ModelAndView Show() {
        ModelAndView modelAndView = new ModelAndView();
        Person person = new Person();
        person.setAge(20);
        person.setName("zhangsan");
        personService.addPerson(person);
        System.out.println("in Show model");
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
