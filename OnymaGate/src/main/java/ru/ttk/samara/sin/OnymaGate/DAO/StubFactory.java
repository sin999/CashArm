package ru.ttk.samara.sin.OnymaGate.DAO;

import org.apache.axis.message.SOAPHeaderElement;
import org.springframework.stereotype.Service;
import ru.onyma.www.services.OnymaApi.OnymaApi;
import ru.onyma.www.services.OnymaApi.OnymaApiLocator;
import ru.onyma.www.services.OnymaApi.OnymaApiSoapBindingStub;
import sun.util.logging.resources.logging;

import javax.inject.Named;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import java.security.Security;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.12.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StubFactory {
    public static OnymaApiSoapBindingStub getStub(String username,String password) throws ServiceException,SOAPException {
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

//    public void test(){
//        SSLClientAxisEngineConfig axisConfig = new SSLClientAxisEngineConfig();
//        axisConfig.setKeystore("/path/to/clientkey.p12");
//        axisConfig.setKeystoreType("PKCS12");
//        axisConfig.setKeystorePassword("changeit");
//        axisConfig.setTruststore("/path/to/truststore.jks");
//        axisConfig.setTruststoreType("JKS");
//        axisConfig.setTruststorePassword("changeit");
//        if (logging)
//             axisConfig.setDebugBaseDir("/path/to/logs");
//        axisConfig.initialize(logging);
//         // initialize service
//         URL soapURL = new URL("https://myserver.com/myapp/services/mywebserviceport");
//         MyWebServiceServiceLocator locator = new MyServiceLocator(axisConfig);
//         MyWebServicePort port = locator.getMyWebServicePort(soapURL);
//         MyWebServiceBindingStub stub = (MyWebServiceBindingStub) port;
//    }




}
