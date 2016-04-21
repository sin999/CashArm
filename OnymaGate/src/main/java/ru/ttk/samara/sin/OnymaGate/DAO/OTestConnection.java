package ru.ttk.samara.sin.OnymaGate.DAO;

import org.springframework.stereotype.Service;
import ru.onyma.www.services.OnymaApi.OnymaApiSoapBindingStub;
import ru.onyma.www.services.OnymaApi.funcs.O_obj_api_obj_date_to_val_request;
import ru.onyma.www.services.OnymaApi.funcs.O_obj_api_obj_date_to_val_response;
import ru.onyma.www.services.OnymaApi.types.T_exception;

import javax.inject.Named;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
* Created by Admin on 11.06.14.
*/

@Service
public class OTestConnection {

    public boolean doTest(String login,String password)throws RemoteException{
        boolean testResult=false;
        try {
            OnymaApiSoapBindingStub stub = StubFactory.getStub(login, password);
            testResult=testRequest(stub);
        } catch (SOAPException e){
            e.printStackTrace();
        }
        catch (ServiceException serviceException){
            serviceException.printStackTrace();
        }
        return testResult;
    }

    private boolean testRequest(OnymaApiSoapBindingStub stub) throws RemoteException{
        boolean isOK = false;
        O_obj_api_obj_date_to_val_request request = new O_obj_api_obj_date_to_val_request();
        O_obj_api_obj_date_to_val_response response=null;
        Calendar happyNewYear2014 = Calendar.getInstance();
        happyNewYear2014.set(2014, Calendar.JANUARY, 1);
        request.setP_val(happyNewYear2014);
        try{
            response = stub.o_obj_api_obj_date_to_val(request);
            isOK = true;
        } catch (T_exception e){
//            The achievement  this point means that the login or password or both were wrong!
//            System.out.println("It's a T_exception exception instance!");
        }
//        catch (RemoteException e){
//            System.out.println("It's a Remote exception instance!");
//            e.printStackTrace();
//        }
        return isOK;
    }

    public String injectionTest(){
        return "Injection works wary well!";
    }
}
