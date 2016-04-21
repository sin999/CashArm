package ru.ttk.samara.sin.OnymaGate.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ttk.samara.sin.OnymaGate.DAO.OTestConnection;

import javax.inject.Inject;
import javax.inject.Named;
import java.rmi.RemoteException;

/**
 * Created by Admin on 16.06.14.
 */
@Service
public class PaymentService {
    @Autowired
    private OTestConnection oTestConnection;

    public boolean checkConnection(String login,String password) throws RemoteException{
        return oTestConnection.doTest(login, password);
    }

}
