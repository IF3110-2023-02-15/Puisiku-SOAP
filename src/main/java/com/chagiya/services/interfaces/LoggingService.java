package com.chagiya.services.interfaces;

import javax.xml.ws.handler.MessageContext;

public interface LoggingService {
    void log(MessageContext mc, String description, String endpoint, String requester);
}


