package com.paytrace.integration.valueobject;

public class InternalValueObject {
    
//    public enum Transxtype { Sale, Authorization, Str_Fwd, Refund, Void, Capture, Force }
    
    private String un;
    private String pswd;
    private String method;
    private String transxtype;
    private char terms;
    private String cc;
    private int expmnth;
    private int expyr;
    private double amt;
    private String baddress;
    private String bzip;
    private String invoice;
    private String url;
    private String parmName;
    private String parmList;
    private String transactionId;
    
    private int errorFlag;
    
    public InternalValueObject(int error) {
        this.errorFlag = error;
    }
    
    
    public InternalValueObject(String un, 
                               String pw, 
                               String method, 
                               String trns, 
                               char terms,
                               String cc, 
                               int expmnth, 
                               int expyr, 
                               double amount) {
        this.un = un;
        this.pswd = pw;
        this.transxtype = trns;
        this.method = method;
        this.terms = terms;
        this.cc = cc;
        this.expmnth = expmnth;
        this.expyr = expyr;
        this.amt = amount;
    }
    
    public InternalValueObject(String un, 
                               String pw, 
                               String method, 
                               String trns, 
                               char terms,
                               String transactionId) {
        this.un = un;
        this.pswd = pw;
        this.transxtype = trns;
        this.method = method;
        this.terms = terms;
        this.transactionId = transactionId;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getUn() {
        return un;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getPswd() {
        return pswd;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setTransxtype(String transxtype) {
        this.transxtype = transxtype;
    }

    public String getTransxtype() {
        return transxtype;
    }

    public void setTerms(char terms) {
        this.terms = terms;
    }

    public char getTerms() {
        return terms;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCc() {
        return cc;
    }

    public void setExpmnth(int expmnth) {
        this.expmnth = expmnth;
    }

    public int getExpmnth() {
        return expmnth;
    }

    public void setExpyr(int expyr) {
        this.expyr = expyr;
    }

    public int getExpyr() {
        return expyr;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public double getAmt() {
        return amt;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBzip(String bzip) {
        this.bzip = bzip;
    }

    public String getBzip() {
        return bzip;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName;
    }

    public String getParmName() {
        return parmName;
    }

    public void setParmList(String parmList) {
        this.parmList = parmList;
    }

    public String getParmList() {
        return parmList;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setErrorFlag(int errorFlag) {
        this.errorFlag = errorFlag;
    }

    public int getErrorFlag() {
        return errorFlag;
    }
}
