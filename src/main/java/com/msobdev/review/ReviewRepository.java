package com.msobdev.review;

import com.msobdev.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by sob1 on 20.07.2017.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {


}
