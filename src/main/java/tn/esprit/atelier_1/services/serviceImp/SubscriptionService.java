package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Subscription;
import tn.esprit.atelier_1.enums.TypeSubscription;
import tn.esprit.atelier_1.repositories.SubscriptionRepository;
import tn.esprit.atelier_1.services.ISubscriptionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubscriptionService  implements ISubscriptionService {
    private final SubscriptionRepository repository;

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return repository.findAllByTypeSubscriptionOrderByStartDateDesc(type);
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return repository.findAllByStartDateAndEndDate(startDate, endDate);
    }
}
