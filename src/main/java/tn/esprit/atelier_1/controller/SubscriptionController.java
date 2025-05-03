package tn.esprit.atelier_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.atelier_1.entity.Subscription;
import tn.esprit.atelier_1.enums.TypeSubscription;
import tn.esprit.atelier_1.services.ISubscriptionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final ISubscriptionService service;

    @GetMapping("get-subscriptions-by-type/{type}")
    public Set<Subscription> getSubscriptionByType(
            @PathVariable("type") TypeSubscription type
    ) {
        return service.getSubscriptionByType(type);
    }

    @GetMapping("get-subscriptions-by-dates/{startDate}/{endDate}")
    public List<Subscription> getSubscriptionByDates(
            @PathVariable("startDate") LocalDate startDate,
            @PathVariable("endDate") LocalDate endDate
    ) {
        return service.retrieveSubscriptionsByDates(startDate, endDate);
    }
}
