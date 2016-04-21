package cashArm.onyma.DAO;

import org.apache.axis.message.SOAPHeaderElement;
import ru.onyma.www.services.OnymaApi.OnymaApi;
import ru.onyma.www.services.OnymaApi.OnymaApiLocator;
import ru.onyma.www.services.OnymaApi.OnymaApiSoapBindingStub;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;
import java.security.Security;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.12.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
@Named
@SessionScoped
public class StubFactory implements Serializable{
    private static OnymaApiSoapBindingStub instance;
    private  static final String DEFAULT_LOGIN="PaymentCollector";
    private  static final String DEFAULT_PASSWORD="wD6KmJdU";

    private String login = DEFAULT_LOGIN;
    private String password = DEFAULT_PASSWORD;

    @Produces
    @Named
//    @Random
    public static OnymaApiSoapBindingStub getDefaultStub(){
        if(instance==null){
            try{
                instance=getStub(DEFAULT_LOGIN,DEFAULT_PASSWORD);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    public OnymaApiSoapBindingStub getOnymaStub(){
        return getAuthorisedStub();
    }

    public  OnymaApiSoapBindingStub getAuthorisedStub(){
        if(instance==null){
            try{
                instance=getStub(login,password);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void eraseSoap(){
        instance=null;
        login=null;
        password=null;
    }


    public static OnymaApiSoapBindingStub getStub(String username,String password) throws Exception {
        System.setProperty("java.protocol.handler.pkgs",
                "com.sun.net.ssl.internal.www.protocol");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        System.setProperty("org.apache.axis.components.net.SecureSocketFactory",
                "org.apache.axis.components.net.SunFakeTrustSocketFactory");
        // Сервис
        OnymaApi service = new OnymaApiLocator("https://10.110.32.138/services_onyma_api/service.htms?name=OnymaApi");
        // Заглушка
        OnymaApiSoapBindingStub stub = (OnymaApiSoapBindingStub) service.getOnymaApi();
        // Заголовок
        SOAPHeaderElement oHeaderElement;
        javax.xml.soap.SOAPElement oElement;
//        oHeaderElement = new SOAPHeaderElement("http://10.110.32.138/services/OnymaApi/heads/", "credentials");
        oHeaderElement = new SOAPHeaderElement("http://www.onyma.ru/services/OnymaApi/heads/", "credentials");
        oHeaderElement.setPrefix("heads");
        oHeaderElement.setMustUnderstand(false);
        oElement = oHeaderElement.addChildElement("username");
        oElement.addTextNode(username);
        oElement = oHeaderElement.addChildElement("password");
        oElement.addTextNode(password);
        stub.setHeader(oHeaderElement);
        return stub;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
