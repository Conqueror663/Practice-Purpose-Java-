package com.Practice.Web.service;

import com.Practice.Web.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> list = new ArrayList<>(Arrays.asList(
            new Student("Usman", 19, 1),
            new Student("Nadeem", 50, 2)
    ));

    public List<Student> getStudentList() {
        return list;
    }

    public void findById(Integer id){
        for (int i = 0; i < list.size(); i++) {
            if(id == list.get(i).getId()){
                System.out.println("Id available" + list.get(i));
                return;
            }
        }
        System.out.println("Id Not Found");
    }

    public void addStudent(Student student) {
        list.add(student);

    }
}
