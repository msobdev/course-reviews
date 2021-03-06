package com.msobdev.review;

import com.msobdev.core.BaseEntity;
import com.msobdev.course.Course;
import com.msobdev.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by sob1 on 20.07.2017.
 */
@Entity
public class Review extends BaseEntity{

    private int rating;
    private  String description;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User reviewer;

    protected Review(){
        super();
    }

    public Course getCourse() {
        return course;
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

