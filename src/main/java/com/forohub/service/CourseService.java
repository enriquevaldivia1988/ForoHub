package com.forohub.service;

import com.forohub.domain.Course;
import com.forohub.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDTO courseDTO);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void deleteCourse(Long id);
}
