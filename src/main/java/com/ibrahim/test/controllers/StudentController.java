package com.ibrahim.test.controllers;

import com.ibrahim.test.pojo.PersonalInfo;
import com.ibrahim.test.pojo.Student;
import com.ibrahim.test.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger log = LoggerFactory.getLogger(StudentController.class);

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET Methods
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId) {

        //









        Student student = studentService.getStudent(studentId);

        if (student == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(student);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{studentId}/info")
    public ResponseEntity<PersonalInfo> getStudentInfo(@PathVariable Integer studentId) {
        PersonalInfo personalInfo = studentService.getStudentInfo(studentId);

        if (personalInfo == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(personalInfo);
    }

    //PUT Methods
    @PutMapping()
    public ResponseEntity<Student> addStudent(@RequestBody String studentJSON) {
//        log.info("student: {}", studentJSON);
        Student studentResponse = studentService.addStudent(studentJSON);

        return ResponseEntity.ok().body(studentResponse);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudentInfo(@PathVariable Integer studentId, @RequestBody PersonalInfo personalInfo) {
        Student student = studentService.updateStudentInfo(studentId, personalInfo);

        if (student == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(student);
    }

    //DELETE METHODS
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer studentId) {
        Student student = studentService.deleteStudent(studentId);

        return ResponseEntity.ok().body(student);
    }
}
