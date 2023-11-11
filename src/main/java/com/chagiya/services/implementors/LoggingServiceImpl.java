package com.chagiya.services.implementors;

import com.chagiya.models.LoggingModel;
import com.chagiya.repositories.LoggingRepository;
import com.chagiya.services.interfaces.LoggingService;
import lombok.NoArgsConstructor;

import javax.xml.ws.handler.MessageContext;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;

@NoArgsConstructor
public class LoggingServiceImpl implements LoggingService {
    @Override
    public void log(MessageContext mc, String description, String endpoint, String requester) {
        HttpExchange exchange = (HttpExchange) mc.get("com.sun.xml.ws.http.exchange");
        InetSocketAddress remoteAddress = exchange.getRemoteAddress();
        String ipAddress = remoteAddress.getAddress().getHostAddress();

        LoggingModel lm = new LoggingModel(description, ipAddress, endpoint, requester);

        LoggingRepository lr = new LoggingRepository();
        lr.addLogging(lm);
    }
}

