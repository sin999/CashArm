package cashArm.onyma.app;
import java.security.Security;
import java.util.Calendar;
import java.util.Random;

import org.apache.axis.message.SOAPHeaderElement;

import ru.onyma.www.services.OnymaApi.*;
import ru.onyma.www.services.OnymaApi.funcs.*;

//import junit.framework.TestCase;
//import junit.textui.TestRunner;

public class OnymaApiClient {
    
    private OnymaApi service;
    private OnymaApiSoapBindingStub stub;
    private static String username;
    private static String password;
    private Random rand;
    private static double dogId=507809.0d;
    
    public OnymaApiClient (){
//        super (name);
    }

    public static void main(String[] args) throws Exception {
//        if (args.length < 2) {
//            throw new java.lang.Exception("Usage: basefile username password");
//        }
        username = "s.proskuryakov";
        password = "rkby-OK";
        System.out.println("OnymaApiClient\n");
        OnymaApiClient apiClient = new OnymaApiClient();
        apiClient.doWork();
        //TestRunner.run(OnymaApiClient.class);
    }

    public void doWork(){
        try {
            setUp();
            test_o_mdb_api_get_dog_get_dognum_by_dogid();
            double dogNum=test_o_mdb_api_get_dog_get_dognum_by_dogid(414186.0d );
            double dogId = test_o_mdb_api_get_dog_get_dognum_by_dogid1(dogNum);
            System.out.println("Contract number ="+dogNum);
            System.out.println("Contract identifier ="+dogId);
        }catch (Exception e){
            System.out.println("doWork error");
            e.printStackTrace();

        }
    }
    
    public void setUp() throws Exception {
        System.setProperty("java.protocol.handler.pkgs",
            "com.sun.net.ssl.internal.www.protocol");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        System.setProperty("org.apache.axis.components.net.SecureSocketFactory",
            "org.apache.axis.components.net.SunFakeTrustSocketFactory");
        // Сервис
        service = new OnymaApiLocator();
        // Заглушка
        stub = (OnymaApiSoapBindingStub) service.getOnymaApi();
        // Заголовок
        SOAPHeaderElement oHeaderElement;
        javax.xml.soap.SOAPElement oElement;
        oHeaderElement = new SOAPHeaderElement(
            "http://www.onyma.ru/services/OnymaApi/heads/", "credentials");
        oHeaderElement.setPrefix("heads");
        oHeaderElement.setMustUnderstand(false);
        oElement = oHeaderElement.addChildElement("username");
        oElement.addTextNode(username);
        oElement = oHeaderElement.addChildElement("password");
        oElement.addTextNode(password);
        stub.setHeader(oHeaderElement);
    }
    
    public void test_o_mdb_api_change_dog_dog_create() throws Exception {
        System.out.println("test_o_mdb_api_change_dog_dog_create");
        rand = new Random();
        rand.setSeed(Calendar.getInstance().getTimeInMillis());
        // Запрос
        O_mdb_api_change_dog_dog_create_request req = new O_mdb_api_change_dog_dog_create_request(
            12.0,                           // double pgid,
            Calendar.getInstance(),         // java.util.Calendar pdogdate,
            "test_api_" + rand.nextInt(),   // java.lang.String pdogcode,
            3.0,                            // double putid,
            2.0,                            // double pcsid,
            2.0,                            // double ptsid,
            null,                           // java.lang.Double pppid,
            null                            // java.lang.Double ptartypeid
        );
        // Вызов
        O_mdb_api_change_dog_dog_create_response res = stub.o_mdb_api_change_dog_dog_create(req);
        dogId = res.get_return();
        // Ответ
        System.out.println("Created dog id: " + dogId);
        System.out.println("--------------------------------------------------------------------------------\n");
    }
    
    public void test_o_mdb_api_get_dog_get_dognum_by_dogid() throws Exception {
        System.out.println("test_o_mdb_api_get_dog_get_dognum_by_dogid");
        // Запрос
        O_mdb_api_get_dog_get_dognum_by_dogid_request req = new O_mdb_api_get_dog_get_dognum_by_dogid_request(dogId);
        // Вызов
        O_mdb_api_get_dog_get_dognum_by_dogid_response res = stub.o_mdb_api_get_dog_get_dognum_by_dogid(req);
        // Ответ
        System.out.println("Created dog num: " + res.get_return());
        System.out.println("--------------------------------------------------------------------------------\n");
    }
    public double test_o_mdb_api_get_dog_get_dognum_by_dogid1(double dogId) throws Exception {
        System.out.println("test_o_mdb_api_get_dog_get_dognum_by_dogid");
        // Запрос
        O_mdb_api_get_dog_get_dognum_by_dogid_request req = new O_mdb_api_get_dog_get_dognum_by_dogid_request(dogId);
        // Вызов
        O_mdb_api_get_dog_get_dognum_by_dogid_response res = stub.o_mdb_api_get_dog_get_dognum_by_dogid(req);
        // Ответ
        return   res.get_return();
//        System.out.println("Created dog num: " + res.get_return());
//        System.out.println("--------------------------------------------------------------------------------\n");
    }

    public double test_o_mdb_api_get_dog_get_dognum_by_dogid(double dogNum) throws Exception {
        System.out.println("test_o_mdb_api_get_dog_get_dognum_by_dogid");
        // Запрос
        O_mdb_api_get_dog_get_dogid_by_dognum_request req = new O_mdb_api_get_dog_get_dogid_by_dognum_request(dogNum);
        // Вызов
        O_mdb_api_get_dog_get_dogid_by_dognum_response res = stub.o_mdb_api_get_dog_get_dogid_by_dognum(req);
        // Ответ
        return   res.get_return();
//        System.out.println("Created dog num: " + res.get_return());
//        System.out.println("--------------------------------------------------------------------------------\n");
    }
    
    public void test_o_mdb_api_func_get_dogcode() throws Exception {
        System.out.println("test_o_mdb_api_func_get_dogcode");
        // Запрос
        O_mdb_api_func_get_dogcode_request req = new O_mdb_api_func_get_dogcode_request(dogId);
        // Вызов
        O_mdb_api_func_get_dogcode_response res = stub.o_mdb_api_func_get_dogcode(req);
        // Ответ
        System.out.println("Created dog code: " + res.get_return());
        System.out.println("--------------------------------------------------------------------------------\n");
    }



}