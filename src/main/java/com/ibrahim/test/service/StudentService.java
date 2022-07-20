package com.ibrahim.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibrahim.test.pojo.PersonalInfo;
import com.ibrahim.test.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    Map<Integer, Student> students;
    ObjectMapper objectMapper;

    @Autowired
    public StudentService(ObjectMapper objectMapper) {
        students = new HashMap<>();
        this.objectMapper = objectMapper;
    }

    public Student getStudent(Integer studentId) {
        return students.get(studentId);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public PersonalInfo getStudentInfo(Integer studentId) {
        Student student = students.get(studentId);

        if (student != null) return student.getPersonalInfo();
        else return null;
    }

    public Student addStudent(String studentJSON) {
        Student student = null;
        try {
            student = objectMapper.readValue(studentJSON, Student.class);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        System.out.println(student);

        if (student == null) return null;

        return students.put(student.getStudentId(), student);
    }

    public Student deleteStudent(Integer studentId) {
        return students.remove(studentId);
    }

    public Student updateStudentInfo(Integer studentId, PersonalInfo personalInfo) {
        Student student = students.get(studentId);

        if (student != null) student.setPersonalInfo(personalInfo);

        return student;
    }
}
