package src.com.paytrace.test;

import java.util.logging.Logger;

import src.com.paytrace.integration.response.IntegrationResponse;
import src.com.paytrace.integration.service.CCIntegrationServiceImpl;
import src.com.paytrace.integration.valueobject.ExternalValueObject;

public class TestCCIntegrationService {
    
    private static Logger logger = Logger.getLogger("CCIntegration Test");
    
    /**
     * This is a shell for a test method - this will not run as is, but is a start
     * @param args
     */
    public static void main(String[] args) {
        
        CCIntegrationServiceImpl service = new CCIntegrationServiceImpl();
        ExternalValueObject externalValueObject = new ExternalValueObject();
        
        externalValueObject.setUsername("username");
        externalValueObject.setPassword("password");
        
        externalValueObject.setAmount(100.00);
        externalValueObject.setTransactionType("transactionType");
        
        // etc.
        
        IntegrationResponse response = service.processExternalRequest(externalValueObject);
        
        logger.info(response.getAvsresponse());
    }
}
