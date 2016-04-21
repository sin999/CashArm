package cashArm.onyma.DAO.Adapters;



import ru.onyma.www.services.OnymaApi.types.O_mdb_api_map_main_return_row;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class ApiRow2AuthNameAdapter extends OAuthName implements Serializable{
    private  O_mdb_api_map_main_return_row return_row;

    public ApiRow2AuthNameAdapter(OContract contract, O_mdb_api_map_main_return_row return_row){
        setContract(contract);
        this.return_row=return_row;
    }

    public ApiRow2AuthNameAdapter(O_mdb_api_map_main_return_row return_row){
        this.return_row=return_row;
    }
//    <complexType name="o_mdb_api_map_main_return_row">
//    dmid - Учетное имя                    <element name="dmid" type="xs:double" nillable="true"/>
//    domainid - Домен                      <element name="domainid" type="xs:double" nillable="true"/>
//    sitename - Назв. учетного имени       <element name="sitename" type="xs:string" nillable="true"/>
//    dogid - Договор                       <element name="dogid" type="xs:double" nillable="true"/>
//    bill - Лицевой счет уч. имени         <element name="bill" type="xs:double" nillable="true"/>
//    remark - Комментарий                  <element name="remark" type="xs:string" nillable="true"/>
//    dogbill - Лицевой счет договора       <element name="dogbill" type="xs:double" nillable="true"/>
//    rootdomain - Домен (root)             <element name="rootdomain" type="xs:double" nillable="true"/>
//    whenmake - Дата создания              <element name="whenmake" type="xs:dateTime" nillable="true"/>
//    deldate - Дата закрытия               <element name="deldate" type="xs:dateTime" nillable="true"/>
//    lockadm - Блокировка на с.с.          <element name="lockadm" type="xs:string" nillable="true"/>
//    makedmid - Родительское учетно имя    <element name="makedmid" type="xs:double" nillable="true"/>
//    tartypeid - Прейскурант               <element name="tartypeid" type="xs:double" nillable="true"/>


    @Override
    public Double getBill() {
        return return_row.getBill();    
    }

    @Override
    public Date getDelDate() {
        return return_row.getDeldate()==null?null:return_row.getDeldate().getTime();
    }

    @Override
    public Double getDmId() {
        return return_row.getDmid();    
    }

    @Override
    public Double getDogBill() {
        return return_row.getDogbill();    
    }

    @Override
    public Double getDomainId() {
        return return_row.getDomainid();    
    }

    @Override
    public String getLockAdm() {
        return return_row.getLockadm();    
    }

    @Override
    public Double getMakeDmId() {
        return return_row.getMakedmid();    
    }

    @Override
    public String getRemark() {
        return return_row.getRemark();    
    }

    @Override
    public Double getRootDomain() {
        return return_row.getRootdomain();    
    }

    @Override
    public String getSiteName() {
        return return_row.getSitename();    
    }

    @Override
    public Double getTarTypeId() {
        return return_row.getTartypeid();    
    }

    @Override
    public Date getWhenMake() {
        return return_row.getWhenmake()==null?null:return_row.getWhenmake().getTime();
    }
}

