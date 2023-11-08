package com.chagiya.services.implementors;

import com.chagiya.models.SubscriptionModel;
import com.chagiya.repositories.LoggingRepository;
import com.chagiya.repositories.SubscriptionRepository;
import com.chagiya.services.interfaces.SubscriptionService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SubscriptionServiceImpl implements SubscriptionService {
    private final LoggingServiceImpl ls;
    public SubscriptionServiceImpl() {
        ls = new LoggingServiceImpl();
    }

    @Override
    public String subscribe(@WebParam(name = "email") String email) {
        SubscriptionModel sm = new SubscriptionModel(email);

        SubscriptionRepository sr = new SubscriptionRepository();
        sr.addLogging(sm);
        ls.log(email);
        
        return "Email " + email + " has successfully subscribed";
    }

    @Override
    public String checkSubscription(@WebParam(name = "email") String email) {
        return "Email " + email + " has a subscription!";
    }
}
