package cashArm.bbeans;

//
//import ru.ttk.samara.sin.OnymaGate.ServiceImpl.PaymentService;
//import ru.ttk.samara.sin.OnymaGate.ServiceImpl.ServiceFactory;

import cashArm.onyma.DAO.OperatorLoginChecker;
//import ru.ttk.samara.sin.OnymaGate.app.TestApp1;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Admin on 10.06.14.
 */
@Named
@SessionScoped
public class AuthBean implements Serializable{
    @Inject
    private OperatorLoginChecker operatorLoginChecker;

       private String login;
       private String password;
       private Boolean isLoggedIn;


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

    public String doLogin(){
        boolean isLoginOk = true;
        if (isLoggedIn==null || !isLoggedIn){
            isLoginOk= isLoginGood();
        }
        return isLoginOk?"success":"failure";
    }

    public boolean isBadLogin(){
        return isLoggedIn==null?false:isLoggedIn;
    }

    public boolean isLoginGood(){
        Boolean isGood=operatorLoginChecker.checkLogin(login,password);
        return isGood==null?false:isGood;
    }

    public String  doLogout(){
        login=null;
        password=null;
        operatorLoginChecker.logout();
        return "logout";
    }
}
