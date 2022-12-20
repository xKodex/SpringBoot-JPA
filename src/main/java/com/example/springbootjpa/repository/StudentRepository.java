package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Course;
import com.example.springbootjpa.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public void retrieveStudentAndCourse(){
        Student student= em.find(Student.class, 90001L);
        logger.info("student -> {}", student);
        logger.info("course -> {}", student.getCourses());
    }


    public void insertStudentAndCourse(){
        Student student=new Student("Jack");
        Course course=new Course("Microservice in 100 steps");
        em.persist(student);
        em.persist(course);
        student.addCourses(course);
        course.addStudent(student);
        em.persist(student);
        //logger.info("student -> {}", student);
        //logger.info("course -> {}", student.getCourses());
    }


    public void insertStudentAndCourse2(Student student,Course course){

        student.addCourses(course);
        course.addStudent(student);
        em.persist(student);
        //logger.info("student -> {}", student);
        //logger.info("course -> {}", student.getCourses());
    }


}
