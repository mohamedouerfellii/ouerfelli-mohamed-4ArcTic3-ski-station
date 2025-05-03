package tn.esprit.atelier_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.enums.TypeSubscription;

import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
    List<Skier> findAllBySubscriptionTypeSubscription(TypeSubscription typeSubscription);
}
