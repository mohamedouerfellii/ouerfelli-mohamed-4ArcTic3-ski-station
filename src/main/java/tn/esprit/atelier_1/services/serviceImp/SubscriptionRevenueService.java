package tn.esprit.atelier_1.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.atelier_1.entity.Subscription;
import tn.esprit.atelier_1.repositories.SubscriptionRepository;
import tn.esprit.atelier_1.services.ISubscriptionRevenueService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionRevenueService implements ISubscriptionRevenueService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    @Scheduled(cron = "0 0 8 1 * ?")
    public void showMonthlyRecurringRevenue() {
        List<Subscription> activeSubscriptions = subscriptionRepository.findActiveSubscriptions();

        float totalRevenue = 0f;
        for (Subscription sub : activeSubscriptions) {
            totalRevenue += sub.getPrice();
        }

        System.out.println("MRR Report - "+ java.time.LocalDate.now().getMonth());
        System.out.println(" Monthly Recurring Revenue: "+ totalRevenue + " DT from " + activeSubscriptions.size() + " active subscriptions");
    }
}
