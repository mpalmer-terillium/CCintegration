package com.paytrace.integration.util;

import com.paytrace.integration.response.IntegrationResponse;
import com.paytrace.integration.valueobject.ExternalValueObject;
import com.paytrace.integration.valueobject.InternalValueObject;
import static com.paytrace.integration.constants.IntegrationConstants.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class IntegrationUtility {
    
    private static Logger logger = Logger.getLogger(PAY_TRACE);
    
    /**
     * Initialize a new InternalValueObject based on the values in and the trasaction type of the ExternalValueObject.
     * 
     * @param evo
     * @return InternalValueObject
     */
    public static InternalValueObject initVO(ExternalValueObject evo) {
        InternalValueObject internalVO;
        
        if (evo.getTransactionType().equalsIgnoreCase(TRANS_TYPE_AUTHORIZATION) ||
            evo.getTransactionType().equalsIgnoreCase(TRANS_TYPE_SALE)) {
            
            internalVO = new InternalValueObject(evo.getUsername(), 
                                                 evo.getPassword(), 
                                                 evo.getMethod(), 
                                                 evo.getTransactionType(), 
                                                 evo.getTerms(),
                                                 evo.getCreditCardNumber(), 
                                                 evo.getExpirationMonth(), 
                                                 evo.getExpirationYear(), 
                                                 evo.getAmount());
            internalVO.setUrl(PAYTRACE_URL);
            internalVO.setParmName(PAYTRACE_PARMNAME);
            internalVO.setErrorFlag(OK);
            
        } else if (evo.getTransactionType().equalsIgnoreCase(TRANS_TYPE_CAPTURE)) {
            
            internalVO = new InternalValueObject(evo.getUsername(), 
                                                 evo.getPassword(), 
                                                 evo.getMethod(), 
                                                 evo.getTransactionType(), 
                                                 evo.getTerms(),
                                                 evo.getTransactionId());
            internalVO.setUrl(PAYTRACE_URL);
            internalVO.setParmName(PAYTRACE_PARMNAME);
            internalVO.setErrorFlag(OK);
            
        } else if(evo.getTransactionType().equalsIgnoreCase(TRANS_TYPE_VERIFY)) {
            
            internalVO = new InternalValueObject(ERROR);
            /*
             * This is not currently implemented - figure it out
             */
            
        } else {
            
            internalVO = new InternalValueObject(ERROR);
        }
        
        return internalVO;
    }
    
    /**
     * According to the API, the name value pair string needs to look this way, so this is simply doing that.
     * See: tokenize for the magic involved.
     * 
     * @param internalVO
     * @return String name value pair
     */
    public static String createParameterList(InternalValueObject internalVO) {
        
        return tokenize(USERNAME_TOKEN, internalVO.getUn()) + 
               tokenize(PASSWORD_TOKEN, internalVO.getPswd()) +
               tokenize(METHOD_TOKEN, internalVO.getMethod()) +
               tokenize(TRANSACTION_TYPE_TOKEN, internalVO.getTransxtype()) +
               tokenize(TERMS_TOKEN, internalVO.getTerms() + "") +
               tokenize(CREDIT_CARD_TOKEN, internalVO.getCc()) + 
               tokenize(EXPIRATION_MONTH_TOKEN, internalVO.getExpmnth() + "") +
               tokenize(EXPIRATION_YEAR_TOKEN, internalVO.getExpyr() + "") +
               tokenize(AMOUNT_TOKEN, internalVO.getAmt() + "");
    }
    
    /**
     * Take the response string and split the values then map them into an IntegrationResponse.
     * If there are errors, the response won't contain anything but the error message, so just get that and get out.
     * 
     * @param content
     * @param integrationResponse
     * @return IntegrationResponse
     */
    public static IntegrationResponse mapIntegrationResponse(String content, IntegrationResponse integrationResponse) {
        
        String[] contentTokens = content.split(REGEX_TOKEN_SPLIT);
        Map<String,String> mappingPairs = new HashMap<>();
        
        // map over all by two, increasing twice each time - this is a non traditional loop.
        for(int i = 0; i < contentTokens.length - 1; ) {
            mappingPairs.put(contentTokens[i++], contentTokens[i++]);
        }
        
        if(mappingPairs.containsKey(PAYTRACE_ERROR)) {
            
            integrationResponse.setResponse(mappingPairs.get(PAYTRACE_ERROR));
            
        } else {
            
            integrationResponse.setAvsresponse(mappingPairs.get(PAYTRACE_AVSRESPONSE));
            integrationResponse.setAppmsg(mappingPairs.get(PAYTRACE_APPMSG));
            integrationResponse.setTransactionid(mappingPairs.get(PAYTRACE_TRASACTIONID));
            integrationResponse.setAppcode(mappingPairs.get(PAYTRACE_APPCODE));
            integrationResponse.setResponse(mappingPairs.get(PAYTRACE_RESPONSE));
        }
        return integrationResponse;
    }
    
    /**
     * Logger function - keeps you informed, yo!
     * 
     * @param evo
     * @param rsp
     */
    public static void logResult(ExternalValueObject evo, IntegrationResponse rsp) {
        
        String response = rsp.getResponse();
        
        if (response.contains(APPROVED_CODE)) {
            logger.info(evo.getTransactionType() + REQ_APPROVED);
        } else if (response.contains(NOT_APPROVED_CODE)) {
            logger.info(evo.getTransactionType() + REQ_NOT_APPROVED);
        } else if (response.contains(INVALID_CODE)) {
            logger.info(evo.getTransactionType() + REQ_INVALID);
        } else {
            logger.info(evo.getTransactionType() + REQ_ERROR + response);
        }
    }
    
    /**
     * make "Hello" and "Bear" into "Hello~Bear|".  Pure magic.
     * @param pre
     * @param post
     * @return Tokenized String
     */
    private static String tokenize(String pre, String post) {
        return pre + "~" + post + "|";
    }
}
