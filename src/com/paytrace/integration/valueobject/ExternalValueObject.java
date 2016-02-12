package src.com.paytrace.integration.valueobject;

public class ExternalValueObject {

    private String url;
    private String parmName;
    private String username;
    private String password;
    private String method;
    private String transactionType;
    private char terms;
    private String creditCardNumber;
    private int expirationMonth;
    private int expirationYear;
    private double amount;
    private String transactionId;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTerms(char terms) {
        this.terms = terms;
    }

    public char getTerms() {
        return terms;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
