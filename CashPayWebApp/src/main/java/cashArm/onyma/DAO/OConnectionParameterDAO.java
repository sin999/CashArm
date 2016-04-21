package cashArm.onyma.DAO;

import cashArm.onyma.DAO.Adapters.ApiRow2ConnectionParameter;

import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_get_connection_get_props_list_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_get_connection_get_props_list_response;
import ru.onyma.www.services.OnymaApi.types.T_o_mdb_tt_props_row;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OConnectionParameter;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
@Named("oConnectionParameterDAO")
public class OConnectionParameterDAO extends AbstractDAO{


    public List<OConnectionParameter>  getParameterList(OConnection connection){
        List<OConnectionParameter> parameterList = new ArrayList<OConnectionParameter>();
        O_mdb_api_get_connection_get_props_list_request request= new  O_mdb_api_get_connection_get_props_list_request();
        request.setPclsrv(connection.getId());

        O_mdb_api_get_connection_get_props_list_response response;
        try {
            response=getStab().o_mdb_api_get_connection_get_props_list(request);
            for (T_o_mdb_tt_props_row prop:response.get_return()){
                parameterList.add(new ApiRow2ConnectionParameter(connection,prop));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return parameterList;
    }

    public Map<Double,String> getParameterMap(OConnection connection){
        Map<Double,String> map = new HashMap<Double, String>();
        for (OConnectionParameter parameter:getParameterList(connection)){
            map.put(parameter.getProp(),parameter.getVal());
        }
        return map;
    }
}
