package src.com.paytrace.test;

import java.util.logging.Logger;

import src.com.paytrace.integration.response.IntegrationResponse;
import src.com.paytrace.integration.service.CCIntegrationServiceImpl;
import src.com.paytrace.integration.util.IntegrationUtility;
import src.com.paytrace.integration.valueobject.ExternalValueObject;
import src.com.paytrace.integration.valueobject.SoftCodingCredentials;

public class TestCCIntegrationService {
    
    private static Logger logger = Logger.getLogger("CCIntegration Test");
    
    /**
     * Test method used to validate that the service is working for value objects (not SOAP requests).
     * Uses softcoding, so the softcoding service must also be present, or else un / pw values must be entered.
     * @param args
     */
    public static void main(String[] args) {
        
        CCIntegrationServiceImpl service = new CCIntegrationServiceImpl();
        ExternalValueObject externalValueObject = initExternalValueObject(new ExternalValueObject());
        
        IntegrationResponse response = service.processExternalRequest(externalValueObject);
        
        logger.info(response.getAvsresponse());
    }
    
    private static ExternalValueObject initExternalValueObject(ExternalValueObject externalValueObject) {

        SoftCodingCredentials scr = IntegrationUtility.securitySetup();
        
        if (scr.hasCredentials()) {
            
            externalValueObject.setUsername(scr.getUsername());
            externalValueObject.setPassword(scr.getPassword());        
            externalValueObject.setParmName("PARMLIST");
            externalValueObject.setMethod("processtransx");
            externalValueObject.setTerms('Y');
            externalValueObject.setTransactionType("Authorization");
            externalValueObject.setAmount(100.00);
            externalValueObject.setCreditCardNumber("4012881888818888");
            externalValueObject.setExpirationMonth(12);
            externalValueObject.setExpirationYear(16);
            
        } else {
            
            externalValueObject.setUsername("Enter username here!");
            externalValueObject.setPassword("Enter password here!");        
            externalValueObject.setParmName("PARMLIST");
            externalValueObject.setMethod("processtransx");
            externalValueObject.setTerms('Y');
            externalValueObject.setTransactionType("Authorization");
            externalValueObject.setAmount(100.00);
            externalValueObject.setCreditCardNumber("4012881888818888");
            externalValueObject.setExpirationMonth(12);
            externalValueObject.setExpirationYear(16);
        }
        return externalValueObject;
    }
    
    
}
