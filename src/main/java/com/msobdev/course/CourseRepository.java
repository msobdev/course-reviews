package com.msobdev.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by sob1 on 20.07.2017.
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);
}
