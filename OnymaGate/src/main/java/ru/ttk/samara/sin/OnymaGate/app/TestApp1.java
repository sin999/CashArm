package ru.ttk.samara.sin.OnymaGate.app;

import ru.onyma.www.services.OnymaApi.OnymaApiSoapBindingStub;
import ru.onyma.www.services.OnymaApi.funcs.O_obj_api_obj_date_to_val_request;
import ru.onyma.www.services.OnymaApi.funcs.O_obj_api_obj_date_to_val_response;
import ru.onyma.www.services.OnymaApi.types.T_exception;
import ru.ttk.samara.sin.OnymaGate.DAO.StubFactory;
import ru.ttk.samara.sin.OnymaGate.ServiceImpl.PaymentService;
import ru.ttk.samara.sin.OnymaGate.ServiceImpl.ServiceFactory;

import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
 * Created by Admin on 11.06.14.
 */
public class TestApp1 {
 public static String login="s.proskuryakov";
 public static String password="rkby-OK";
    public static void main(String[] args) {
        TestApp1 app=new TestApp1();
//        app.serviceTest();
        app.doTest(login,password);
    }


    public void serviceTest(){
        try{
            PaymentService paymentService = ServiceFactory.getPaymentService();
            try{
                System.out.println(paymentService.checkConnection(login, password) ? "Login OK" : "Login Failed");
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Exception was caught");
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void doTest(String login,String password){
        System.out.println(tryOutTest(login,password));
    }

    public String tryOutTestDefault(){
        return tryOutTest(login,password);
    }

    public String tryOutTest(String login,String password){
        String retValue="I've got nothing to return";
        try {
            OnymaApiSoapBindingStub stub = StubFactory.getStub(login, password);
            boolean testResult=testRequest(stub);
            retValue=(testResult?"No errors have been found! And I couldn't say it made me sad!":"It's seamed that something went badly!");
        } catch (SOAPException e){
            retValue=("It's a SOAP exception instance!");
            e.printStackTrace();
        }
        catch (ServiceException serviceException){
            retValue=("It's a service exception instance!");

            serviceException.printStackTrace();
        }
        return retValue;
    }

    private boolean testRequest(OnymaApiSoapBindingStub stub){
        boolean isOK = false;
        O_obj_api_obj_date_to_val_request request = new O_obj_api_obj_date_to_val_request();
        O_obj_api_obj_date_to_val_response response=null;
        Calendar happyNewYear2014 = Calendar.getInstance();
        happyNewYear2014.set(2014, Calendar.JANUARY, 1);
        request.setP_val(happyNewYear2014);
        try{
            response = stub.o_obj_api_obj_date_to_val(request);
            System.out.println(response.toString());
            isOK = true;
        } catch (T_exception e){
//            The achievement  this point means that the login or password or both were wrong!
//            System.out.println("It's a T_exception exception instance!");
//            System.out.println("Message is >> "+ e.getMessage());
//            System.out.println("Cause is >> "+ e.getCause());
//            System.out.println("Cause is >> "+ e.getFaultReason());



//            e.printStackTrace();
        }catch (RemoteException e){
            System.out.println("It's a Remote exception instance!");
            e.printStackTrace();
        }
        return isOK;
    }
}
