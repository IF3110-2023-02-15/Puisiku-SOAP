package com.chagiya.services.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface SubscriptionService {
    @WebMethod
    public String subscribe(@WebParam(name = "email") String email, @WebParam(name = "creatorId") int creatorId);

    @WebMethod
    public int getSubscriberCount(@WebParam(name = "creatorId") int creatorId);
}
