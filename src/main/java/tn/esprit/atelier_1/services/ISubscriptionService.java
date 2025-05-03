package tn.esprit.atelier_1.services;

import tn.esprit.atelier_1.entity.Subscription;
import tn.esprit.atelier_1.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionService {
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate,
                                                    LocalDate endDate);
}
