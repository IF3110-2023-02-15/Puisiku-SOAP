package com.chagiya.services.implementors;

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
        ls.log(email);
        return "Email " + email + " has successfully subscribed";
    }

    @Override
    public String checkSubscription(@WebParam(name = "email") String email) {
        return "Email " + email + " has a subscription!";
    }
}
