package kz.bitlab.springboot.thymeleaftask1demo.controllers;

import kz.bitlab.springboot.thymeleaftask1demo.db.DBUtil;
import kz.bitlab.springboot.thymeleaftask1demo.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String mainPage(Model model){
        ArrayList<Student> students = DBUtil.getStudents();

        model.addAttribute("studentter", students);
        return "main";
    }
    @GetMapping(value = "/addStudent")
    public String addStudents(){
        return "add";
    }
    @PostMapping(value = "/addStudent")
    public String addStudents(@RequestParam(name = "name") String name,
                              @RequestParam(name = "surname") String surname,
                              @RequestParam(name = "exam") int exam){
        String mark=null;
        if(exam>=90){
            mark="A";
        }
        else if(exam>=75 && exam<=89){
            mark="B";
        }
        else if(exam>=60 && exam<=74){
            mark="C";
        }
        else if(exam>=50 && exam<=59){
            mark="D";
        }
        else{
            mark="F";
        }

        Student student = new Student(DBUtil.getIndex(),name,surname,exam,mark);
        DBUtil.addStudent(student);

        return "redirect:/";
    }
}
