package com.chagiya.main;

import com.chagiya.services.implementors.SubscriptionServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    private static final String HOST_IP = "0.0.0.0";
    private static final String PORT = "8888";

    public static void main(String[] args) {
        publishEndpoint("/subscription", new SubscriptionServiceImpl());
    }

    private static void publishEndpoint(String path, Object service) {
        try {
            Endpoint.publish("http://" + HOST_IP + ":" + PORT + path, service);
            System.out.println("SOAP service serve and list on " + HOST_IP + ":" + PORT + path);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
