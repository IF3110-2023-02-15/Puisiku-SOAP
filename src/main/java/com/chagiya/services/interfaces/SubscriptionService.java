package com.chagiya.services.interfaces;

import com.chagiya.models.response.Response;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface SubscriptionService {
    @WebMethod
    public Response subscribe(@WebParam(name = "email") String email, @WebParam(name = "creatorId") int creatorId);

    @WebMethod
    public Response getSubscriberCount(@WebParam(name = "creatorId") int creatorId);
}
