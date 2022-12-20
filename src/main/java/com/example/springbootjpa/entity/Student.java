package com.example.springbootjpa.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name="student_courses",
    joinColumns=@JoinColumn(name = "students_id"), inverseJoinColumns = @JoinColumn(name="courses_id")
    )
    private List<Course> courses= new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    /*@OneToOne
    private Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }*/
}
