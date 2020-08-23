package com.manning.sbip.ch02.cotroller;

import javax.validation.Valid;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        model.addAttribute("courses", courses.isEmpty() ? null : courses);
        return "index";
    }

    @GetMapping("/addcourse")
    public String showAddCourseForm(Course course) {
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String addCourse(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseRepository.save(course);
        model.addAttribute("courses", courseRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateCourseForm(@PathVariable("id") long id, Model model) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course", course);
        return "update-course";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setId(id);
            return "update-course";
        }

        courseRepository.save(course);
        model.addAttribute("courses", courseRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") long id, Model model) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        courseRepository.delete(course);
        model.addAttribute("courses", courseRepository.findAll());
        return "index";
    }
}
