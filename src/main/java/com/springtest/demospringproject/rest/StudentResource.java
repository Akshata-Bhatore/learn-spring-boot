package com.springtest.demospringproject.rest;

import com.springtest.demospringproject.domain.Student;
import com.springtest.demospringproject.repository.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/student/api/")
public class StudentResource {

    @Autowired
    StudentRepository repository;
    private static final Logger log = LogManager.getLogger(HostNameResource.class);


    @PostMapping("/create")
    public String createStudent(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email){
        Student student = new Student(firstName,lastName,email);
        repository.save(student);
        return "Student "+firstName+" has been created";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam Long id){
        Student student =  repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Student not found with id"+id));
        repository.delete(student);
        return "Student "+id+" has been deleted";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestParam Long id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email){
        Student student =  repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Student not found with id"+id));
        if(StringUtils.isEmpty(firstName)){
            student.setFirstName(firstName);
        }
        if(StringUtils.isEmpty(lastName)){
            student.setLastName(lastName);
        }
        if(StringUtils.isEmpty(email)) {
            student.getEmail(email);
        }

        repository.save(student);
        return "Student "+id+" has been updated";
    }

    @GetMapping("/get")
    public String getStudent(@RequestParam Long id){
        Student student =  repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Student not found with id"+id));
        return "Student firstName: "+student.getFirstName() +" lastname: "+student.getLastName();
    }

}
