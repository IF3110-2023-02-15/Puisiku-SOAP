package com.chagiya.services.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface SubscriptionService {
    @WebMethod
    String subscribe(@WebParam(name = "email") String email, @WebParam(name = "creatorId") Integer creatorId);

    @WebMethod
    String checkSubscription(@WebParam(name = "email") String email);
}
