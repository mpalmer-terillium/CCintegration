package src.com.paytrace.integration.internalprocessor;

import src.com.paytrace.integration.response.IntegrationResponse;
import src.com.paytrace.integration.util.IntegrationUtility;
import src.com.paytrace.integration.valueobject.InternalValueObject;
import static src.com.paytrace.integration.constants.IntegrationConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class InternalIntegrationProcessor {
    
    private HttpClient httpClient;
    private HttpPost httpPost;
    private List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
    private int errorFlag;
    
    /**
     * This is the internal integration processor method, which passes off the internal value object
     * to the init method.
     * 
     * @param internalVO
     */
    public InternalIntegrationProcessor(InternalValueObject internalVO) {
        super();
        init(internalVO);
    }
    
    /**
     * Initialize the HttpClient object, the HttpPost object, and the NameValuePair list.
     * 
     * @param internalVO
     */
    protected void init(InternalValueObject internalVO) {
        
        if(internalVO.getErrorFlag() != ERROR) {
            
            errorFlag = OK;
            httpClient = HttpClientBuilder.create().build();
            httpPost = new HttpPost(internalVO.getUrl());
            nameValuePairList.add(new BasicNameValuePair(internalVO.getParmName(), 
                                                         IntegrationUtility.createParameterList(internalVO)));
        }
    }
    
    /**
     * Attempt to execute the POST request, saving the response.
     * This method will also cleanse the inputs (look for null values).
     * @return IntegrationResponse
     */
    public IntegrationResponse doPost() {
        
        IntegrationResponse integrationResponse = new IntegrationResponse();
        
        if(!nameValuePairList.isEmpty()) {
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
    
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                
                
                if (entity != null) {
                    IntegrationUtility.mapIntegrationResponse(EntityUtils.toString(entity), integrationResponse);
                }
            } catch (Exception e) {
                    e.printStackTrace();
                    integrationResponse.setResponse(e.getMessage());
                    
            } finally {
                httpPost.releaseConnection();
            }
        } else {
            integrationResponse.setResponse(PROCESSING_ERROR_MSG);
        }
        return integrationResponse;
    }
    
    /**
     * Getter for the errorFlag.
     * 
     * @return int (error check constant)
     */
    public int errorCheck() {
        return errorFlag;
    }
}