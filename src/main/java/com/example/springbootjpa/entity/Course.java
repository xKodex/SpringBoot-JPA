package com.example.springbootjpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="Course")
@NamedQuery(name="query_get_all_courses",query="select c from Course c")
//@NamedQueries(value ={@NamedQuery(name=""
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }


    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    //@OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "course")
    private List<Review> reviews=new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students= new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course(){}

    public Course(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
