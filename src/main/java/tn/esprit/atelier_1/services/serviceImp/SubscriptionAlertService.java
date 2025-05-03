package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Skier;
import tn.esprit.atelier_1.repositories.SkierRepository;
import tn.esprit.atelier_1.services.ISubscriptionAlertService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionAlertService implements ISubscriptionAlertService {
    private final SkierRepository repository;

    @Override
    @Scheduled(cron = "0 0 8 * * ?")
    public void retrieveSubscriptions() {
        LocalDate now = LocalDate.now();
        LocalDate nextWeek = now.plusDays(7);

        List<Skier> skiers = repository.findSkiersWithSubscriptionsExpiringSoon(now, nextWeek);

        if (skiers.isEmpty()) {
            System.out.println("No expiring subscriptions in the next 7 days.");
            return;
        }

        System.out.println("Upcoming expiring subscriptions:");
        for (Skier skier : skiers) {
            System.out.println(
                    "Subscription " + skier.getSubscription().getNumSub() +
                            " - Skier : " + skier.getNumSkier() + " - First Name : " + skier.getFirstName() +
                            " - Last name : " + skier.getLastName() + " - End date subscription : " + skier.getSubscription().getEndDate()
            );
        }
    }
}
