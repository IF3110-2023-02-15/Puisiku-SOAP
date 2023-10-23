package com.chagiya.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebService(targetNamespace = "http://services.chagiya.com/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class LoggingService {
    public LoggingService() {
        System.out.println("Constructed Logging Service");
    }

    @WebMethod
    public String hello() {
        return "Hello World";
    }

    @WebMethod
    public String log(@WebParam(name = "message") String message) {
        System.out.println("Hello from log");
        System.out.println(message);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String logMessage = "<log>\n"
                + "  <timestamp>" + now.format(formatter) + "</timestamp>\n"
                + "  <message>" + message + "</message>\n"
                + "</log>";

        return logMessage;
    }
}
