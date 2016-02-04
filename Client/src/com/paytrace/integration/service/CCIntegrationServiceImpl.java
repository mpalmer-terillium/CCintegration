package com.paytrace.integration.service;

import com.paytrace.integration.internalprocessor.InternalIntegrationProcessor;

import com.paytrace.integration.response.IntegrationResponse;
import com.paytrace.integration.util.IntegrationUtility;
import com.paytrace.integration.valueobject.ExternalValueObject;
import static com.paytrace.integration.constants.IntegrationConstants.*;

import java.util.logging.Logger;

import javax.jws.WebService;

@WebService(endpointInterface="com.paytrace.integration.service.CCIntegrationService")
public class CCIntegrationServiceImpl implements CCIntegrationService {
    
    /**
     * Pass the ExternalValueObject to the IntegrationUtility for initialization,
     * then create a new InternalIntegrationProcessor with it.
     * If all goes well, process the request as an HTTP POST call and get a response.
     * Otherwise, set an error on the response.
     * 
     * @param evo
     * @return IntegrationResponse
     */
    @Override
    public IntegrationResponse processExternalRequest(ExternalValueObject evo) {
        
        InternalIntegrationProcessor processor = new InternalIntegrationProcessor(IntegrationUtility.initVO(evo));
        IntegrationResponse response;
        
        if(processor.errorCheck() != ERROR) {
            
            response = processor.doPost();
            IntegrationUtility.logResult(evo, response);
            
        } else {
            
            response = new IntegrationResponse();
            response.setResponse(PROCESSING_ERROR_MSG);
        }
        return response;
    }
}