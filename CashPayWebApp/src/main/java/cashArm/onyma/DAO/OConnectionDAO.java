package cashArm.onyma.DAO;

import cashArm.onyma.DAO.Adapters.ApiRow2ConnectionAdapter;
import ru.onyma.www.services.OnymaApi.funcs.*;
import ru.onyma.www.services.OnymaApi.types.*;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OContract;

import javax.inject.Named;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.02.14
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
@Named("oConnectionDAO")
public class OConnectionDAO extends AbstractDAO{


    public void setStatus(OConnection connection,Double status){
        O_mdb_api_change_connection_set_status_force_request request = new O_mdb_api_change_connection_set_status_force_request();
        request.setPclsrv(connection.getId());
        request.setPstatus(status);
        Calendar startDate= Calendar.getInstance();
        startDate.setTime(new Date());

       request.setPdate(startDate);
        O_mdb_api_change_connection_set_status_force_response response=null;
        try{
            response = getStab().o_mdb_api_change_connection_set_status_force(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



   public void setConnectionTariff(OConnection connection,Double tariffId){
       O_mdb_api_change_connection_set_tmid_request request = new O_mdb_api_change_connection_set_tmid_request();
       request.setPtmid(tariffId);
       request.setPclsrv(connection.getId());
       Calendar startDate= Calendar.getInstance();
       startDate.setTime(new Date());
//       request.setPstart_date(startDate);
       O_mdb_api_change_connection_set_tmid_response response = null;
       try{
          response = getStab().o_mdb_api_change_connection_set_tmid(request);
       }catch (Exception e){
           e.printStackTrace();
       }
   }

    public void recallConnection(OConnection connection){
       O_mdb_api_change_connection_recalcconnection_request request = new O_mdb_api_change_connection_recalcconnection_request();
       request.setP_clsrv(connection.getId());
       Calendar startDate= Calendar.getInstance();
       startDate.setTime(new Date());
        startDate.add(Calendar.DATE,-1);
       request.setP_sd(startDate);
        request.setP_setstatus(0.0);
        O_mdb_api_change_connection_recalcconnection_response response = null;
       try{
          response = getStab().o_mdb_api_change_connection_recalcconnection(request);
       }catch (Exception e){
           e.printStackTrace();
       }
   }
    public void connectionCorrect(OConnection connection){
        O_mdb_api_change_connection_upd_request request = new O_mdb_api_change_connection_upd_request();
        request.setPclsrv(connection.getId());
        Calendar startDate= Calendar.getInstance();
        startDate.setTime(new Date());
        startDate.add(Calendar.DATE,-1);
        request.setP_begdate(startDate);
        O_mdb_api_change_connection_upd_response response = null;
        try{
            response = getStab().o_mdb_api_change_connection_upd(request);
        }catch (Exception e){
            System.out.println("ошибка при корректировке подключения Договор " +connection.getAuthName().getContract().getDogcode()+" Учетное имя  "+connection.getAuthName().getSiteName()+" подключение"+connection.getName());
            e.printStackTrace();
        }
//        <element name="o_mdb_api_change_connection_upd_request">
//        <complexType>
//        <annotation>
//        <documentation>Запрос. изменить параметры подключения
//        pclsrv - id подключения
//        p_notes - примечания
//        p_begdate - дата начала
//        p_enddate - дата окончания
//        p_tmid - тарифный план
//        p_shared - область видимости
//        p_ssd - начать с</documentation>
//        </annotation>
//        <sequence>
//        <element name="pclsrv" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_notes" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_begdate" type="xs:dateTime" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_enddate" type="xs:dateTime" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_tmid" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_shared" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//        <element name="p_ssd" type="xs:dateTime" nillable="true" minOccurs="0" maxOccurs="1"/>
//        </sequence>
//        </complexType>
//        </element>
//        <element name="o_mdb_api_change_connection_upd_response">
    }



//    public OConnection createConnection(OAuthName authName,Double pserv,Double ptmid,List<OConnectionParameter> parameterList){
////        pdmid - id учетного имени
////        pserv - id ресурса
////        ptmid - id тарифного плана
////        pstatus - статус подключения
////        pdate - дата начала подключения
////        premark - примечание</documentation>
//        Double id=null;
//         if(pserv!=null && ptmid!=null){
//                O_mdb_api_change_connection_conn_create_wp_request request =new  O_mdb_api_change_connection_conn_create_wp_request();
//                O_mdb_api_change_connection_conn_create_wp_response response=null;
//                request.setPdmid(authName.getDmId());
//                request.setPserv(pserv);
//                request.setPtmid(ptmid);
//                Calendar date=Calendar.getInstance();
//                date.setTime(new Date());
//                request.setPdate(date);
//                List<T_o_mdb_tt_props_row> list=new ArrayList<T_o_mdb_tt_props_row>();
//                for (OConnectionParameter parameter:parameterList){
//                    T_o_mdb_tt_props_row props_row = new T_o_mdb_tt_props_row();
//                    props_row.setProp(parameter.getProp());
//                    props_row.setVal(parameter.getVal());
//                    props_row.setNum(parameter.getNum());
//                    list.add(props_row);
//                }
//                request.setPprop(list.toArray(new T_o_mdb_tt_props_row[list.size()]));
//
//                try {
//                    response=stub.o_mdb_api_change_connection_conn_create_wp(request);
//                }catch (Exception e){
//                    System.out.println(authName.getContract().getDogcode()+" couldn't add tariff ptmid - "+ ptmid +" mess "+e.getMessage());
//        //            e.printStackTrace();
//                }
//                 id= response==null?null:response.get_return();
//         }
//        return id==null?null:findById(authName,id);
//    }


    public OConnection findById(OAuthName authName,Double id){
        List<OConnection> connectionList =new ArrayList<OConnection>();
        O_mdb_api_client_services_request request= new O_mdb_api_client_services_request();
        T_id_1 t_id_1=new T_id_1();
        t_id_1.setIs(id);
        request.setId(t_id_1);
        O_mdb_api_client_services_response response;
        try {
            response=getStab().o_mdb_api_client_services(request);
            for (O_mdb_api_client_services_return_row conn:response.get_return()){
                connectionList.add(new ApiRow2ConnectionAdapter(authName,conn));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connectionList.size()>0?connectionList.get(0):null;
    }

public List<OConnection> findByAuthName(OAuthName authName){
    List<OConnection> connectionList =new ArrayList<OConnection>();
    O_mdb_api_client_services_request request= new O_mdb_api_client_services_request();
    T_dmid_1 t_dmid_1=new T_dmid_1();
    t_dmid_1.setIs(authName.getDmId());
    request.setDmid(t_dmid_1);
    O_mdb_api_client_services_response response;
    try {
        response=getStab().o_mdb_api_client_services(request);
        for (O_mdb_api_client_services_return_row conn:response.get_return()){
            connectionList.add(new ApiRow2ConnectionAdapter(authName,conn));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return connectionList;
}
    public List<OConnection> findByContract(OContract contract){
        List<OConnection> connectionList =new ArrayList<OConnection>();
        O_mdb_api_client_services_request request= new O_mdb_api_client_services_request();
        T_dogid_1 t_dogid_1 = new T_dogid_1();
        t_dogid_1.setIs(contract.getDogid());
        request.setDogid(t_dogid_1);
        O_mdb_api_client_services_response response;
        try {
            response=getStab().o_mdb_api_client_services(request);
            for (O_mdb_api_client_services_return_row conn:response.get_return()){
                connectionList.add(new ApiRow2ConnectionAdapter(conn));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connectionList;
    }
//    <element name="o_mdb_api_client_services_request">
//    <complexType>
//    <annotation>
//    <documentation>Запрос. Подключения (без истории групп)
//    id - Подключение
//    dmid - Учетное имя
//    service - Ресурс
//    startdate - Дата начала
//    enddate - Дата окончания
//    startdatetime - Дата/время начала
//    enddatetime - Дата/время окончания
//    tmid - Тарифный план
//    status - Статус
//    name - Наименование
//    gid - Группa
//    notes - Примечания
//    dogid - Договор
//    shared - Область видимости
//    dadd - Дата добавления
//    conn_name - Название подключения (из списка подключений)
//    lastop - Результат последней операции обмена с упр.сервером
//    status_qualif - Квалификатор изменения статуса
//    rows_skip - пропустить указанное количество строк результата
//    rows_limit - выбрать указанное количество строк результата</documentation>
//    </annotation>
//    <sequence>
//    <element name="id" type="types:t_id_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="dmid" type="types:t_dmid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="service" type="types:t_service_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="startdate" type="types:t_startdate_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="enddate" type="types:t_enddate_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="startdatetime" type="types:t_startdatetime_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="enddatetime" type="types:t_enddatetime_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="tmid" type="types:t_tmid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="status" type="types:t_status_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="name" type="types:t_name_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="gid" type="types:t_gid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="notes" type="types:t_notes_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="dogid" type="types:t_dogid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="shared" type="types:t_shared_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="dadd" type="types:t_dadd_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="conn_name" type="types:t_conn_name_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="lastop" type="types:t_lastop_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="status_qualif" type="types:t_status_qualif_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="rows_skip" type="xs:int" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="rows_limit" type="xs:int" nillable="true" minOccurs="0" maxOccurs="1"/>
}
