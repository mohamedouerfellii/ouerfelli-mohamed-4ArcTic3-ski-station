package tn.esprit.atelier_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.atelier_1.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
