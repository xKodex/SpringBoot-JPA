package com.example.springbootjpa.entity;

import javax.persistence.*;

@Entity
public class Review {

    public Review() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne()
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private String rating;

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
