package src.com.paytrace.integration.valueobject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoftCodingCredentials{
    
    private String username;
    private String password;


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
    
    public boolean hasCredentials() {
        return this.username != null && this.password != null;
    }
}
