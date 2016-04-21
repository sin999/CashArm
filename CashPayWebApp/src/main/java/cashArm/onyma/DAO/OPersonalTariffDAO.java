package cashArm.onyma.DAO;

import cashArm.Common.OEntityes.main.OTariff;
import cashArm.onyma.DAO.Adapters.ApiRow2OPersonalTariffAdapter;
import cashArm.onyma.DAO.Adapters.ApiRow2OTariff;
import ru.onyma.www.services.OnymaApi.funcs.*;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_tariff_tm_list_return_row;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_tm_list_return_row;
import ru.onyma.www.services.OnymaApi.types.T_o_mdb_tt_personal_tariff_row;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OPersonalTariff;

import javax.inject.Named;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.02.14
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
@Named("personalTariffDAO")
public class OPersonalTariffDAO extends AbstractDAO{

//    clsrv - Подключение
//    tmid - Тарифный план
//    servid - Услуга
//    cost - Цена
//    begin_date - Дата начала
//    end_date - Дата окончания
//    tdid - ТПТ
//    coeff - Коэффициент
//    serv_alias - Наименование услуги в документе
//    remark - Примечание
//    no_mcost - Флаг "отменить ценовые ступени". значения "yes"/"no".</documentation>

    public List<OPersonalTariff> getConnectionPersonalTariffList(OConnection connection){
        List<OPersonalTariff> personalTariffList = new ArrayList<OPersonalTariff>();
        O_mdb_api_map_main_p_get_personal_tariff_request request= new O_mdb_api_map_main_p_get_personal_tariff_request();
        request.setP_dmid(connection.getAuthName().getDmId());
//        request.setP_clsrv(connection.getId());

        O_mdb_api_map_main_p_get_personal_tariff_response response=null;
//        t_o_mdb_tt_personal_tariff_row
        try {
           response = getStab().o_mdb_api_map_main_p_get_personal_tariff(request);
            for (T_o_mdb_tt_personal_tariff_row row:response.get_return()){
                personalTariffList.add(new ApiRow2OPersonalTariffAdapter(row));
//                System.out.println(row.getServid()+" "+row.getCost());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
       return personalTariffList;
    }

    public void addPersonalTariff(OConnection connection,double additionalServiceId,double cost,Calendar startDate,Calendar endDate){
        O_mdb_api_change_connection_add_personal_tariff_request request = new O_mdb_api_change_connection_add_personal_tariff_request();
        request.setP_clsrv(connection.getId());
        request.setP_servid(additionalServiceId);
        request.setP_begin_date(startDate);
        request.setP_end_date(endDate);
        request.setP_use_default_cost(0.0);
        request.setP_cost(cost);
        O_mdb_api_change_connection_add_personal_tariff_response response=null;

        try{
           response = getStab().o_mdb_api_change_connection_add_personal_tariff(request);
        }  catch (Exception e){
              e.printStackTrace();
        }
    }

//    <element name="o_mdb_api_change_connection_add_personal_tariff_request">
//    <complexType>
//    <annotation>
//    <documentation>Запрос. добавление персонального тарифа на подключение с id = p_clsrv
//    p_clsrv - id подключения, обязательный параметр. из подключения выводится учётное имя, ресурс, тарифный план.
//    p_servid - id услуги. услуга персонального тарифа
//    p_cost - персональная цена
//    p_begin_date - дата начала персонального тарифа
//    p_end_date - дата окончания персонального тарифа
//    p_tdid - точка приземления
//    p_coeff - коэффициент
//    p_use_default_cost - флаг "использовать базовую цену" для случая p_cost := null
//    p_serv_alias - наименование услуги в документе
//    p_remark - комментарий персонального тарифа
//    p_no_mcost - флаг "отменить ценовые ступени". значения "yes"/"no".
//    pccntr - ценовой коэффициент</documentation>
//    </annotation>
//    <sequence>
//    <element name="p_clsrv" type="xs:double" minOccurs="1" maxOccurs="1"/>
//    <element name="p_servid" type="xs:double" minOccurs="1" maxOccurs="1"/>
//    <element name="p_cost" type="xs:double" minOccurs="1" maxOccurs="1"/>
//    <element name="p_begin_date" type="xs:dateTime" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_end_date" type="xs:dateTime" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_tdid" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_coeff" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_use_default_cost" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_serv_alias" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_remark" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_no_mcost" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="pccntr" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    </sequence>
//    </complexType>

    public void addPersonalTariff2AuthName(OAuthName authName,double tariffId,double additionalServiceId,Calendar startDate,Calendar endDate){
        O_mdb_api_map_main_p_add_personal_tariff_request request = new O_mdb_api_map_main_p_add_personal_tariff_request();
        request.setP_dmid(authName.getDmId());
        request.setP_servid(additionalServiceId);
        request.setP_begin_date(startDate);
        request.setP_end_date(endDate);
        request.setP_use_default_cost(1.0);
//        request.setP_cost(350.0);
        request.setP_tmid(tariffId);
        O_mdb_api_map_main_p_add_personal_tariff_response response=null;

        try{
            response = getStab().o_mdb_api_map_main_p_add_personal_tariff(request);
        }  catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Map<Double,OTariff> tariffMap;

    public Map<Double,OTariff> getTariffMap(){
        if(tariffMap==null){
            Map<Double,OTariff> tariffMapTemp = new HashMap<Double, OTariff>();
            O_mdb_api_tm_list_request request=new O_mdb_api_tm_list_request();
            O_mdb_api_tm_list_response response;
            try{
               response = getStab().o_mdb_api_tm_list(request);
                for(O_mdb_api_tm_list_return_row row:response.get_return()){
                    if (row!=null){
                        tariffMapTemp.put(row.getTmid(),new ApiRow2OTariff(row));
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            tariffMap=tariffMapTemp;
        }
        return tariffMap;
    }

    public OTariff getById(Double id){
        return getTariffMap().get(id);
    }


    public OTariff getTariff(OConnection connection){
        Double tmid=null;
        O_mdb_api_get_connection_get_tmid_request request=new O_mdb_api_get_connection_get_tmid_request();
        O_mdb_api_get_connection_get_tmid_response response=null;
        try{
          response = getStab().o_mdb_api_get_connection_get_tmid(request);
            if (response!=null){
                tmid=response.get_return();
            }
        }catch (Exception e){

        }
        return tmid==null?null:getTariffMap().get(tmid);
    }

}