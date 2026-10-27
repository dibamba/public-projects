package com.springboot.sms.contoller;

import com.springboot.sms.dto.StudentDto;
import com.springboot.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler for getting all student list
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    //handler method to create new student
    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    //handler method to handle save student form request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "create_student";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    //handler to edit a student
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long id,
                              Model model){
        StudentDto student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    //handler to update a student
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long id,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "edit_student";
        }

        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    //handler to delete a student
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    //handler to view a student
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long id,
                              Model model){
        StudentDto student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/view_student";
    }
}
