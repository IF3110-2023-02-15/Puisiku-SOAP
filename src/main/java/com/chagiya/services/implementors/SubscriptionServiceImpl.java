package com.chagiya.services.implementors;

import com.chagiya.models.SubscriptionModel;
import com.chagiya.models.response.Response;
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
    public Response subscribe(@WebParam(name = "email") String email, @WebParam(name = "creatorId") int creatorId) {
        SubscriptionModel subscriptionModel = new SubscriptionModel(email, creatorId);

        loggingService.log(email);

        try {
            subscriptionRepository.subscribe(subscriptionModel);
            return new Response(200, email + " subscribed to creator with id " + creatorId);
        } catch(Exception e) {
            return new Response(400, e.toString());
        }
    }

    @Override
    public Response getSubscriberCount(@WebParam(name = "creatorId") int creatorId) {
        Integer subscriberCount = subscriptionRepository.getSubscriberCount(creatorId);
        return new Response(200, subscriberCount.toString());
    }
}
