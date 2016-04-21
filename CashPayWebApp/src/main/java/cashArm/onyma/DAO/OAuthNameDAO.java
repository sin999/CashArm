package cashArm.onyma.DAO;

import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_change_dog_site_create_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_change_dog_site_create_response;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_map_main_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_map_main_response;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_map_main_return_row;
import ru.onyma.www.services.OnymaApi.types.T_dmid_1;
import ru.onyma.www.services.OnymaApi.types.T_dogid_1;
import cashArm.onyma.DAO.Adapters.ApiRow2AuthNameAdapter;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OContract;


import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.02.14
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
@Named("authNameDAO")
public class OAuthNameDAO extends AbstractDAO {

    public List<OAuthName> getByContact(OContract contract){
        List<OAuthName> nameList=new ArrayList<OAuthName>();
        if (contract!=null && contract.getDogid()!=null){
            O_mdb_api_map_main_request request = new O_mdb_api_map_main_request();
            T_dogid_1 t_dogid_1=new T_dogid_1();
            t_dogid_1.setIs(contract.getDogid());
            request.setDogid(t_dogid_1);
            O_mdb_api_map_main_response response;
            try {
              response=getStab().o_mdb_api_map_main(request);
                for (O_mdb_api_map_main_return_row name:response.get_return()){
    //                System.out.println(name.getSitename());
                    nameList.add(new ApiRow2AuthNameAdapter(contract,name));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return nameList;
    }

    public OAuthName getById(Double id){
        O_mdb_api_map_main_request request= new  O_mdb_api_map_main_request();
        T_dmid_1 tDmid1 = new T_dmid_1();
        tDmid1.setIs(id);
        request.setDmid(tDmid1);
        O_mdb_api_map_main_response response=null;
        try{
           response = getStab().o_mdb_api_map_main(request);
        }catch (Exception e){
            e.printStackTrace();
        }

        return (response==null|| response.get_return().length==0)?null:new ApiRow2AuthNameAdapter(response.get_return()[0]);
    }
//    <element name="o_mdb_api_map_main_request">
//    <complexType>
//    <annotation>
//    <documentation>Запрос. Учетные имена
//    dmid - Учетное имя
//    domainid - Домен
//    sitename - Назв. учетного имени
//    dogid - Договор
//    bill - Лицевой счет уч. имени
//    remark - Комментарий
//    dogbill - Лицевой счет договора
//    rootdomain - Домен (root)
//    whenmake - Дата создания
//    deldate - Дата закрытия
//    lockadm - Блокировка на с.с.
//            makedmid - Родительское учетно имя
//    tartypeid - Прейскурант
//    rows_skip - пропустить указанное количество строк результата
//    rows_limit - выбрать указанное количество строк результата</documentation>
//    </annotation>
//    <sequence>
//    <element name="dmid" type="types:t_dmid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="domainid" type="types:t_domainid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="sitename" type="types:t_sitename_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="dogid" type="types:t_dogid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="bill" type="types:t_bill_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="remark" type="types:t_remark_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="dogbill" type="types:t_dogbill_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="rootdomain" type="types:t_rootdomain_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="whenmake" type="types:t_whenmake_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="deldate" type="types:t_deldate_3" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="lockadm" type="types:t_lockadm_2" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="makedmid" type="types:t_makedmid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="tartypeid" type="types:t_tartypeid_1" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="rows_skip" type="xs:int" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="rows_limit" type="xs:int" nillable="true" minOccurs="0" maxOccurs="1"/>
//    </sequence>


    public OAuthName createOAuthName(OContract contract,String siteName,Double pDomainId){
        Double id = createAuthName(contract,siteName,pDomainId);
        OAuthName authName = getById(id);
        authName.setContract(contract);
        return authName;
    }

    public Double createAuthName(OContract contract,String siteName,Double pDomainId){
        O_mdb_api_change_dog_site_create_request request = new O_mdb_api_change_dog_site_create_request();
        request.setPdogid(contract.getDogid());
        request.setPsitename(siteName);
        request.setPdomainid(pDomainId);
        O_mdb_api_change_dog_site_create_response response=null;
        try{
            response = getStab().o_mdb_api_change_dog_site_create(request);
        }catch (Exception e){
              e.printStackTrace();
        }
       return  response==null?null:response.get_return();
}
//    <documentation>Запрос. создать учетное имя
//    psitename - учетное имя создаваемого подключения
//    pdomainid - id домена
//    pdogid - id договора
//    premark - примечание
//    pkeyadm - блокировка просмотра счета на сервере статистики
//    pstatus_inactiv - не активировать подключение
//    pdmidup - родительское учетное имя
//    p_tartypeid - прейскурант</documentation>
//    </annotation>
//    <sequence>
//    <element name="psitename" type="xs:string" minOccurs="1" maxOccurs="1"/>
//    <element name="pdomainid" type="xs:double" minOccurs="1" maxOccurs="1"/>
//    <element name="pdogid" type="xs:double" minOccurs="1" maxOccurs="1"/>
//    <element name="premark" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="pkeyadm" type="xs:string" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="pstatus_inactiv" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="pdmidup" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    <element name="p_tartypeid" type="xs:double" nillable="true" minOccurs="0" maxOccurs="1"/>
//    </sequence>
//    </complexType>
//    </element>
//    <element name="o_mdb_api_change_dog_site_create_response">
//    <complexType>
}
