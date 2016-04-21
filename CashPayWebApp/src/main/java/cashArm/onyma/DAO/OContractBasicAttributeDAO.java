package cashArm.onyma.DAO;


import ru.onyma.www.services.OnymaApi.funcs.*;
import cashArm.Common.OEntityes.main.OContract;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;
@Named("oContractBasicAttributeDAO")
public class OContractBasicAttributeDAO extends AbstractDAO{

    public void saveChangedProperties(OContract oldContract,OContract newContract){
//                 Calendar    startdate;              //STARTDATE t2.Дата начала</a>
//                 Calendar    enddate;                //ENDDATE t2.Дата окончания</a>
//                 Double      bill;                   //BILL t2.Лицевой счет</a>
        if(!isEqual(oldContract.getGid(),newContract.getGid())){saveGid(newContract,newContract.getGid());}
        if(!isEqual(oldContract.getDogcode(),newContract.getDogcode())){saveDogCode(newContract, newContract.getDogcode());}
        if(!isEqual(oldContract.getStatus(),newContract.getStatus())){saveDogStatus(newContract,newContract.getStatus(),Calendar.getInstance());}
//                 Double      orgid;                  //ORGID t2.ID контрагента</a>
//                 Double      dogidup;                //DOGIDUP t2.Головной договор</a>
//                 Double      parent_orgid;           //PARENT_ORGID t2.ID родительского контрагента</a>
//                 Calendar    close_billing_date;     //CLOSE_BILLING_DATE t2.Дата закрытия отчетного периода</a>
//                 Double      whomake;                //WHOMAKE t2.Оператор, создавший договор</a>
        if(!isEqual(oldContract.getTsid(),newContract.getTsid())){saveTsid(newContract, newContract.getTsid());}
        if(!isEqual(oldContract.getCsid(),newContract.getCsid())){saveCsid(newContract, newContract.getCsid());}
        if(!isEqual(oldContract.getUtid(),newContract.getUtid())){saveUtid(newContract, newContract.getUtid());}
    }

    public void saveGid(OContract contract,Double gid){
        O_mdb_api_change_dog_set_gid_request request = new O_mdb_api_change_dog_set_gid_request();
        O_mdb_api_change_dog_set_gid_response response=null;
        request.setPdogid(contract.getDogid());
        request.setPgid(gid);
        try {
            response = getStab().o_mdb_api_change_dog_set_gid(request);
        }catch (Exception e){
         System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }

    public void saveDogCode(OContract contract,String dogCode){
        O_mdb_api_change_dog_set_dogcode_request request =new  O_mdb_api_change_dog_set_dogcode_request();
        O_mdb_api_change_dog_set_dogcode_response response = new O_mdb_api_change_dog_set_dogcode_response();
        request.setPdogid(contract.getDogid());
        request.setPdogcode(dogCode);
        try {
            response = getStab().o_mdb_api_change_dog_set_dogcode(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }
//                 Double      status;                 //STATUS t2.Текущий статус</a>
//                 Calendar    status_date;            //STATUS_DATE t2.Дата установки статуса</a>
    public void saveDogStatus(OContract contract,Double status,Calendar pdate){
        O_mdb_api_change_dog_set_status_request request =new O_mdb_api_change_dog_set_status_request();
        O_mdb_api_change_dog_set_status_response response = null;
        request.setPdogid(contract.getDogid());
        request.setPstatus(status);
        request.setPdate(pdate);
        try {
            response = getStab().o_mdb_api_change_dog_set_status(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }
    public void saveDogStatus(OContract contract,OContract.Status status,Calendar pdate){
        saveDogStatus(contract,status.getId(),pdate);
    }
//                 Double      orgid;                  //ORGID t2.ID контрагента</a>
//                 Double      dogidup;                //DOGIDUP t2.Головной договор</a>
    public void saveOrgId(OContract contract,Double dogUpId){
        O_mdb_api_func_contractor_dog_add_request request= new O_mdb_api_func_contractor_dog_add_request();
        O_mdb_api_func_contractor_dog_add_response response=null;
        request.setPdogidup(dogUpId);
        try {
            response = getStab().o_mdb_api_func_contractor_dog_add(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }
//                 Double      parent_orgid;           //PARENT_ORGID t2.ID родительского контрагента</a>
//                 Calendar    close_billing_date;     //CLOSE_BILLING_DATE t2.Дата закрытия отчетного периода</a>
//                 Double      whomake;                //WHOMAKE t2.Оператор, создавший договор</a>
//                 Double      tsid;                   //TSID t2.Налоговая схема</a>
    public void saveTsid(OContract contract,Double tsid){
        O_mdb_api_change_dog_set_tsid_request request = new O_mdb_api_change_dog_set_tsid_request();
        O_mdb_api_change_dog_set_tsid_response response = null;
        request.setPdogid(contract.getDogid());
        request.setPtsid(tsid);
        try {
            response = getStab().o_mdb_api_change_dog_set_tsid(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }
//                 Double      csid;                   //CSID t2.Кредитная схема</a>
    public void saveCsid(OContract contract,Double csid){
        O_mdb_api_change_dog_set_csid_request request = new O_mdb_api_change_dog_set_csid_request();
        O_mdb_api_change_dog_set_csid_response response = null;
        request.setPdogid(contract.getDogid());
        request.setPcsid(csid);
        try {
            response = getStab().o_mdb_api_change_dog_set_csid(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
}
//                 Double      utid;                   //UTID t2.Тип договора</a>
    public void saveUtid(OContract contract,Double utid){
        System.out.println("Trying to save UTID itid="+utid+"\n");
        O_mdb_api_change_dog_set_usertype_request request = new O_mdb_api_change_dog_set_usertype_request();
        O_mdb_api_change_dog_set_usertype_response response = null;
        request.setPdogid(contract.getDogid());
        request.setPutid(utid);
        try {
            response = getStab().o_mdb_api_change_dog_set_usertype(request);
        }catch (Exception e){
            System.out.println("Couldn't save new Gid for dogovor "+contract.getDogcode());
        }
    }
    private static boolean isEqual(Object o1,Object o2){
        return o1==null?o2==null:o1.equals(o2);
    }
}
