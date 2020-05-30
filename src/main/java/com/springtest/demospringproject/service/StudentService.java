//package com.springtest.demospringproject.service;
//
//import com.springtest.demospringproject.domain.Student;
//import com.springtest.demospringproject.repository.StudentRepository;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityNotFoundException;
//import javax.transaction.Transactional;
//
//@Service
//public class StudentService {
//
//    private StudentRepository repository ;
//    public StudentService (StudentRepository r){
//        this.repository=r;
//    }
//    @Transactional
//    public Student create(Student student){
//        return repository.save(student);
//    }
//    @Transactional
//    public Student findById(Long studentId){
//        return repository.findById(studentId).orElseThrow(()->
//            new EntityNotFoundException("Student not found with id"+studentId));
//    }
//    @Transactional
//    public void delete(Student student){
//        repository.delete(student);
//    }
//
//}
