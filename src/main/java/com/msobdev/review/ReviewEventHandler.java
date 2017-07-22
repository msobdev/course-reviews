package com.msobdev.review;

import com.msobdev.user.User;
import com.msobdev.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by sob1 on 22.07.2017.
 */
@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {

    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review){
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        User user = users.findByUsername(username);
        review.setReviewer(user);
    }
}
