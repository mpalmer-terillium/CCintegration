package src.com.paytrace.integration.constants;


public final class IntegrationConstants {
    
    public static final String PAY_TRACE                = "PayTrace";
    
    public static final String APPROVED_CODE            = "101";
    public static final String NOT_APPROVED_CODE        = "102";
    public static final String INVALID_CODE             = "103";
    
    public static final String REQ_APPROVED             = " Response 101: Your transaction was successfully approved";
    public static final String REQ_NOT_APPROVED         = " Response 102: Your transaction was not approved";
    public static final String REQ_INVALID              = " Response 103: Your transaction was successfully approved. " +
                                                          "However, it was voided because your address and/or CSC did not match";
    public static final String REQ_ERROR                = " Response: Error ";    
    public static final String PAYTRACE_ERROR           = "ERROR";
    
    public static final int ERROR                       = -1;
    public static final int OK                          = 100;
    
    public static final String PROCESSING_ERROR_MSG     = "There were processing errors. Please see log.";
    
    public static final String PAYTRACE_URL             = "https://paytrace.com/api/default.pay";
    public static final String PAYTRACE_PARMNAME        = "PARMLIST";
    public static final String REGEX_TOKEN_SPLIT        = "\\||~";
    
    public static final String USERNAME_TOKEN           = "un";
    public static final String PASSWORD_TOKEN           = "pswd";
    public static final String METHOD_TOKEN             = "method";
    public static final String TRANSX_TYPE_TOKEN        = "tranxtype";
    public static final String TERMS_TOKEN              = "terms";
    public static final String CREDIT_CARD_TOKEN        = "CC";
    public static final String EXP_MONTH_TOKEN          = "expmnth";
    public static final String EXP_YEAR_TOKEN           = "expyr";
    public static final String AMOUNT_TOKEN             = "amount";
    public static final String ADDRESS_TOKEN            = "baddress";
    public static final String ZIP_TOKEN                = "bzip";
    public static final String INVOICE_TOKEN            = "invoice";
    
    public static final String PAYTRACE_AVSRESPONSE     = "AVSRESPONSE";
    public static final String PAYTRACE_APPMSG          = "APPMSG";
    public static final String PAYTRACE_TRASACTIONID    = "TRANSACTIONID";
    public static final String PAYTRACE_APPCODE         = "APPCODE";
    public static final String PAYTRACE_RESPONSE        = "RESPONSE";
    
    public static final String TRANS_TYPE_AUTHORIZATION = "Authorization";
    public static final String TRANS_TYPE_SALE          = "Sale";
    public static final String TRANS_TYPE_CAPTURE       = "Capture";
    public static final String TRANS_TYPE_VERIFY        = "Verify";
    
    public static final String SOFTCODING_URI           = "http://127.0.0.1:7101/MockSoftCodingService/softcoding/credentials/getUnPwd";
}
