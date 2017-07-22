package com.msobdev.core;

import com.msobdev.course.Course;
import com.msobdev.course.CourseRepository;
import com.msobdev.review.Review;
import com.msobdev.user.User;
import com.msobdev.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by sob1 on 21.07.2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courses;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
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

        List<User> students = Arrays.asList(
                new User("msobdev", "michal", "surname", "password", new String[]{"ROLE_USER", "ROLE_ADMIN"}),
                new User("username1", "firstname1", "surname1", "password1", new String[]{"ROLE_USER"}),
                new User("username2", "firstname2", "surname2", "password2", new String[]{"ROLE_USER"}),
                new User("username3", "firstname3", "surname3", "password3", new String[]{"ROLE_USER"}),
                new User("username4", "firstname4", "surname4", "password4", new String[]{"ROLE_USER"}),
                new User("username5", "firstname5", "surname5", "password5", new String[]{"ROLE_USER"}),
                new User("username6", "firstname6", "surname6", "password6", new String[]{"ROLE_USER"}),
                new User("username7", "firstname7", "surname7", "password7", new String[]{"ROLE_USER"}),
                new User("username8", "firstname8", "surname8", "password8", new String[]{"ROLE_USER"})
        );

        users.save(students);

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://msobdev");
                    Review review = new Review((i % 5) + 1, String.format("More %s please", buzzword));
                    review.setReviewer((students.get(i % students.size())));
                    c.addReview(review);
                    bunchOfCourses.add(c);
                });

        courses.save(bunchOfCourses);
    }
}
