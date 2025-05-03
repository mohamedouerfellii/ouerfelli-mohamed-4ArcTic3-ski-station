package tn.esprit.atelier_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.atelier_1.entity.Instructor;
import tn.esprit.atelier_1.enums.Support;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("SELECT c.timeSlot FROM Instructor i JOIN i.courses c " +
            "WHERE c.support =: support " +
            "AND i.numInstructor =: numInstructor")
    List<Integer> numWeeksCourseOfInstructorBySupport(
            @Param("numInstructor") Long numInstructor,
            @Param("support") Support support);
}
