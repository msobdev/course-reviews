package com.msobdev.core;

import com.msobdev.course.Course;
import com.msobdev.course.CourseRepository;
import com.msobdev.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by sob1 on 21.07.2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courses;

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s Advanced"
        };

        String[] buzzwords = {
                "Spring Rest Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate"
        };

        List<Course> bunchOfCourses = new ArrayList<>();

        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://msobdev");
                    c.addReview(new Review(i % 5, String.format("More %s please", buzzword)));
                    bunchOfCourses.add(c);
                });

        courses.save(bunchOfCourses);
    }
}
