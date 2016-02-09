package com.paytrace.integration;


import com.paytrace.integration.service.CCIntegrationServiceImpl;

import javax.xml.ws.Endpoint;


public class CCIntegration {
    /**
     * Main method imitating a deployed BSSV. SOAP requests would be made from outside in the same way.
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ccintegration", new CCIntegrationServiceImpl());
    }
}
