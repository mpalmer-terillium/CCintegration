package src.com.paytrace.integration.service;

import src.com.paytrace.integration.response.IntegrationResponse;
import src.com.paytrace.integration.valueobject.ExternalValueObject;


public interface CCIntegrationService {
    
    IntegrationResponse processExternalRequest(ExternalValueObject evo);
}
