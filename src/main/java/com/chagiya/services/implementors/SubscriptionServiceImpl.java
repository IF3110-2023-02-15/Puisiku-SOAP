package com.chagiya.services.implementors;

import com.chagiya.middlewares.AuthMiddleware;
import com.chagiya.models.SubscriptionModel;
import com.chagiya.models.response.Response;
import com.chagiya.repositories.SubscriptionRepository;
import com.chagiya.services.interfaces.LoggingService;
import com.chagiya.services.interfaces.SubscriptionService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
    private final LoggingService loggingService = new LoggingServiceImpl();

    @Resource
    private WebServiceContext wsContext;

    @Override
    public Response subscribe(@WebParam(name = "email") String email, @WebParam(name = "creatorId") int creatorId) {
        email = email.trim();

        MessageContext mc = wsContext.getMessageContext();

        String apiKey = this.getSpecificHeader("x-api-key");

        if (apiKey == null){
            return new Response(400, "API Key not provided");
        }

        AuthMiddleware am = new AuthMiddleware();
        String authenticated = am.authenticate(apiKey);

        if (authenticated == null) {
            return new Response(401, "Unauthorized Request");
        }

        String description = "Email " + email + " subscribes to creator with id " + creatorId;
        loggingService.log(mc, description, "/subscription/subscribe", authenticated);

        SubscriptionModel subscriptionModel = new SubscriptionModel(email, creatorId);

        try {
            subscriptionRepository.subscribe(subscriptionModel);
            return new Response(200, description);
        } catch(Exception e) {
            return new Response(400, e.toString());
        }
    }

    @Override
    public Response getSubscriberCount(@WebParam(name = "creatorId") int creatorId) {
        MessageContext mc = wsContext.getMessageContext();

        String apiKey = this.getSpecificHeader("x-api-key");

        if (apiKey == null){
            return new Response(400, "API Key not provided");
        }

        AuthMiddleware am = new AuthMiddleware();
        String authenticated = am.authenticate(apiKey);

        if (authenticated == null) {
            return new Response(401, "Unauthorized Request");
        }

        String description = "Get creator with id " + creatorId + " subscriber count";
        loggingService.log(mc, description, "/subscription/getSubscriberCount", authenticated);

        Integer subscriberCount = subscriptionRepository.getSubscriberCount(creatorId);
        return new Response(200, subscriberCount.toString());
    }

    @Override
    public Response getSubscribedCreators(@WebParam(name = "email") String email) {
        email = email.trim();

        MessageContext mc = wsContext.getMessageContext();

        String apiKey = this.getSpecificHeader("x-api-key");

        if (apiKey == null){
            return new Response(400, "API Key not provided");
        }

        AuthMiddleware am = new AuthMiddleware();
        String authenticated = am.authenticate(apiKey);

        if (authenticated == null) {
            return new Response(401, "Unauthorized Request");
        }

        String description = "Get email " + email + " subscribed creators";
        loggingService.log(mc, description, "/subscription/getSubscribedCreator", authenticated);

        try {
            List<Integer> creatorIds = subscriptionRepository.getSubscribedCreators(email);
            return new Response(200, creatorIds.toString());
        } catch (Exception e) {
            return new Response(400, e.toString());
        }
    }

    public String getSpecificHeader(String headerName) {
        MessageContext mc = wsContext.getMessageContext();
        Map http_headers = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> headerValue = (List<String>) http_headers.get(headerName);
        if (headerValue != null && !headerValue.isEmpty()) {
            return headerValue.get(0);
        }
        return null;
    }
}
