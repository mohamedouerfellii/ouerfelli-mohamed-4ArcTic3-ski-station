package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> retrieveAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long numCourse);
}
