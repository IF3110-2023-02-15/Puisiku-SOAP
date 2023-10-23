package com.chagiya.main;

import com.chagiya.services.LoggingService;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://0.0.0.0:8888/logging", new LoggingService());
            System.out.println("SOAP service serve and list on localhost:8888");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}