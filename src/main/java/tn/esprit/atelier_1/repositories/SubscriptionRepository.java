package tn.esprit.atelier_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.atelier_1.entity.Subscription;
import tn.esprit.atelier_1.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Set<Subscription> findAllByTypeSubscriptionOrderByStartDateDesc(TypeSubscription typeSubscription);
    List<Subscription> findAllByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
