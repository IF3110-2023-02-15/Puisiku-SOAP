package com.chagiya.services.implementors;

import com.chagiya.models.SubscriptionModel;
import com.chagiya.repositories.LoggingRepository;
import com.chagiya.repositories.SubscriptionRepository;
import com.chagiya.services.interfaces.LoggingService;
import com.chagiya.services.interfaces.SubscriptionService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
    private final LoggingService loggingService = new LoggingServiceImpl();

    @Override
    public String subscribe(String email, int creatorId) {
        SubscriptionModel subscriptionModel = new SubscriptionModel(email, creatorId);

        subscriptionRepository.subscribe(subscriptionModel);
        loggingService.log(email);

        return "Email" + email + "has succesfully subscribed";
    }

    @Override
    public int getSubscriberCount(int creatorId) {
        return subscriptionRepository.getSubscriberCount(creatorId);
    }
}
