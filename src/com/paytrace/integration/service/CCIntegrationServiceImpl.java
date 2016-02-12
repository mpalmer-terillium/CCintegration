package src.com.paytrace.integration.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import javax.xml.ws.BindingType;

import static src.com.paytrace.integration.constants.IntegrationConstants.ERROR;
import static src.com.paytrace.integration.constants.IntegrationConstants.PROCESSING_ERROR_MSG;
import src.com.paytrace.integration.internalprocessor.InternalIntegrationProcessor;
import src.com.paytrace.integration.response.IntegrationResponse;
import src.com.paytrace.integration.util.IntegrationUtility;
import src.com.paytrace.integration.valueobject.ExternalValueObject;


@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(serviceName = "CCIntegrationService", portName = "IntegrationPort")
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
    @WebMethod
    public IntegrationResponse processExternalRequest(@WebParam(name = "arg0") ExternalValueObject evo) {
        
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