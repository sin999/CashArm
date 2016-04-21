package cashArm.onyma.DAO;


import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_func_get_bcid_remainder_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_func_get_bcid_remainder_response;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_func_get_remainder_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_func_get_remainder_response;
import cashArm.Common.OEntityes.main.OContract;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 06.03.14
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
//@Repository("balanceDAO")
public class OBalanceDAO extends AbstractDAO {

    public Double calculateBalanceOnLastDayOfMonth(OContract contract,Calendar date){
        Double balance=null;
        O_mdb_api_func_get_bcid_remainder_request request = new O_mdb_api_func_get_bcid_remainder_request();
        O_mdb_api_func_get_bcid_remainder_response response=null;
        request.setPdate(date);
        request.setPbill(contract.getBill());
        request.setPignore_bcid(1.0);
        try {
            response= getStab().o_mdb_api_func_get_bcid_remainder(request);
            if (response!= null ){
               balance = response.get_return();
            }
        }  catch (Exception e){
            e.printStackTrace();
        }
       return balance;
    }

    public Double calculateBalanceOnLastDayOfMonthNew(OContract contract,Calendar date){
        Double balance=null;
       if (contract!=null && date!=null){
        O_mdb_api_func_get_remainder_request request = new O_mdb_api_func_get_remainder_request();
        O_mdb_api_func_get_remainder_response response=null;
        request.setPdate(date);
        request.setPbill(contract.getBill());
        try {
            response= getStab().o_mdb_api_func_get_remainder(request);
            if (response!= null ){
               balance = response.get_return();
            }
        }  catch (Exception e){
            e.printStackTrace();
        }
       }
       return balance;
    }
}
