package com.paytrace.integration.response;

public class IntegrationResponse {
    
    private String avsresponse;
    private String appmsg;
    private String transactionid;
    private String appcode;
    private String response;

    public void setAvsresponse(String avsresponse) {
        this.avsresponse = avsresponse;
    }

    public String getAvsresponse() {
        return avsresponse;
    }

    public void setAppmsg(String appmsg) {
        this.appmsg = appmsg;
    }

    public String getAppmsg() {
        return appmsg;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
    
    @Override
    public String toString() {
        return  "\nAVSRESPONSE:\t"   + this.avsresponse +
                "\nAPPMSG:\t\t"      + this.appmsg +
                "\nTRANSACTIONID:\t" + this.transactionid +
                "\nAPPCODE:\t\t"     + this.appcode +
                "\nRESPONSE:\t\t"    + this.response;
    }
}
