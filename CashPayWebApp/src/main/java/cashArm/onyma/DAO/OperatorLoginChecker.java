package cashArm.onyma.DAO;

import ru.onyma.www.services.OnymaApi.funcs.O_res_api_func_ip_addr_to_string_request;
import ru.onyma.www.services.OnymaApi.funcs.O_res_api_func_ip_addr_to_string_response;

import java.io.Serializable;

/**
 * Created by Admin on 19.08.14.
 */
public class OperatorLoginChecker extends AbstractDAO  implements Serializable{

    public boolean checkLogin(String login,String password){
        stubFactory.setLogin(login);
        stubFactory.setPassword(password);
        boolean isOk=false;
        if (login!=null && password!=null){
            isOk=check();
        }
        if (!isOk){
            stubFactory.eraseSoap();
        }
        return isOk;
    }

    private boolean check(){
        O_res_api_func_ip_addr_to_string_request request = new O_res_api_func_ip_addr_to_string_request();
        request.setPaddr(0.0);
        request.setPtype(1.0);
        String result=null;
        O_res_api_func_ip_addr_to_string_response response;
        try{
            response = getStab().o_res_api_func_ip_addr_to_string(request);
            result=response.get_return();
            System.out.println("result is "+result);
        }catch (Exception e){
            System.out.println("Exception takes place! While the login having been checked!");
            e.printStackTrace();
        }
        return "0.0.0.0".equals(result);
    }

    public void logout(){
        stubFactory.eraseSoap();
    }
}
