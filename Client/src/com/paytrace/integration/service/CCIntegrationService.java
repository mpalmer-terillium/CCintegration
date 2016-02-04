package com.paytrace.integration.service;

import com.paytrace.integration.response.IntegrationResponse;
import com.paytrace.integration.valueobject.ExternalValueObject;

import javax.jws.WebMethod;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService
@SOAPBinding(style = Style.RPC)
public interface CCIntegrationService {
    
    @WebMethod
    IntegrationResponse processExternalRequest(ExternalValueObject evo);
}
