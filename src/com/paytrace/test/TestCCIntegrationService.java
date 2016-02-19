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
     * This is a shell for a test method - this will not run as is, but is a start
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
            externalValueObject.setPassword(scr.getPassword());        externalValueObject.setParmName("PARMLIST");
            externalValueObject.setMethod("processtransx");
            externalValueObject.setTerms('Y');
            externalValueObject.setTransactionType("Authorization");
            externalValueObject.setAmount(100.00);
            externalValueObject.setCreditCardNumber("4012881888818888");
            externalValueObject.setExpirationMonth(12);
            externalValueObject.setExpirationYear(16);
            
        } else {
            
        }
        
        
        
        return externalValueObject;
    }
    
    
}
