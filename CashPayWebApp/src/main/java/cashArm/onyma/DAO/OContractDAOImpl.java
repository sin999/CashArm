package cashArm.onyma.DAO;

import cashArm.onyma.DAO.Adapters.ApiRow2OContractAdapter;
import cashArm.onyma.DAO.Exceptions.UnexpectedCountResults;

import cashArm.onyma.common.DataChunk;
import ru.onyma.www.services.OnymaApi.funcs.*;
import ru.onyma.www.services.OnymaApi.types.*;
import cashArm.Common.OEntityes.ConstantsNew.Status;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.Common.OEntityes.main.OContractAttribute;

import javax.inject.Inject;
import javax.inject.Named;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 17.12.13
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
@Named("oContractDAO")
public class OContractDAOImpl extends AbstractDAO implements OContractDAO {

    @Inject
    private OContractBasicAttributeDAO basicAttributeDAO;


    @Override
    public void save(OContract newContract){
        OContract oldContract = findById(newContract.getDogid());
        basicAttributeDAO.saveChangedProperties(oldContract,newContract);
    }

    @Override
    public OContract findOrCreateByCode(String dogCode) throws UnexpectedCountResults {
        OContract oContract=findByCode(dogCode);
        if (oContract==null){
            Double dogId=newContract(dogCode);
            System.out.println(dogId);
            oContract=findById(dogId);
        }
        return oContract;
    }

   @Override
   public OContract findById(double dogId){
       List<OContract> oContractList;
       O_mdb_api_dog_list_request request=new O_mdb_api_dog_list_request();
       T_dogid_1 t_dogid_1=new T_dogid_1();
       t_dogid_1.setIs(dogId);
       request.setDogid(t_dogid_1);
       oContractList=getContractListByRequest(request);
       return oContractList.size()==0?null:oContractList.get(0);
   }




    @Override
    public OContract findByCode(String dogCode) throws UnexpectedCountResults{
//        O_mdb_api_dog_list_request request=new O_mdb_api_dog_list_request();
//        T_dogcode_2 t_dogcode_2=new T_dogcode_2();
//        t_dogcode_2.setIs(dogCode);
//        request.setDogcode(t_dogcode_2);
//        List<OContract> contractList=getContractListByRequest(request);
        List<OContract> contractList =  findByCodeRAW(dogCode);
        if (contractList!=null && contractList.size()>1){
            throw new UnexpectedCountResults();
        }
        return contractList.size()==0?null:contractList.get(0);
    }

    @Override
    public List<OContract> findByCodeRAW(String dogCode){
        O_mdb_api_dog_list_request request=new O_mdb_api_dog_list_request();
        T_dogcode_2 t_dogcode_2=new T_dogcode_2();
        t_dogcode_2.setIs(dogCode);
        request.setDogcode(t_dogcode_2);
        List<OContract> contractList=getContractListByRequest(request);
        for (int i=0;i<contractList.size();i++){
            OContract contract=contractList.get(i);
            if (contract==null || contract.getStatus()==4.0 ){
                contractList.remove(i);
            }
        }
        return contractList;
    }

    private List<OContract> getContractListByRequest(O_mdb_api_dog_list_request request){
        List<OContract> oContractList=new ArrayList<OContract>();
        O_mdb_api_dog_list_response response= null;
        try{
            response = getStab().o_mdb_api_dog_list(request);
        }catch (Exception e){
            //todo
            //To make up what to do with the exception;
            System.out.println("Couldn't getGid");
            e.printStackTrace();
        }

        if(response!=null){
            for (O_mdb_api_dog_list_return_row returnRow:response.get_return()){
                oContractList.add(new ApiRow2OContractAdapter(returnRow));
            }
        }
        return oContractList;
    }

    private  Double newContract(String dogCode){
        O_mdb_api_change_dog_dog_create_request request= new O_mdb_api_change_dog_dog_create_request();
        O_mdb_api_change_dog_dog_create_response response=null;
        request.setPdogcode(dogCode);
        request.setPgid(31110);
        try{
            response= getStab().o_mdb_api_change_dog_dog_create(request);
        }catch (Exception e){
            //todo
            //To make up what to do with the exception;
            System.out.println("Couldn't create new contract");
            e.printStackTrace();
        }
        return response==null?null:response.get_return();
    }

    @Override
    public List<OContract> findByCodePartRAW(String dogCode){
        O_mdb_api_dog_list_request request=new O_mdb_api_dog_list_request();
        T_dogcode_2 t_dogcode_2=new T_dogcode_2();
        t_dogcode_2.setLike(dogCode+"%");
        T_utid_1 t_utid_1=new T_utid_1();
        t_utid_1.setIs_not(OContract.Type.RASHOD.getUtid());
        T_status_1 t_status_1=new T_status_1();
        t_status_1.setIs_not(Status.DELETED.getId());
        request.setUtid(t_utid_1);
        request.setDogcode(t_dogcode_2);
        request.setStatus(t_status_1);
        List<OContract> contractList = new ArrayList<OContract>();
        O_mdb_api_dog_list_response response= null;
        int recordsInPiece= 100;
        int pieceNum =0;
        do{
            request.setRows_limit(recordsInPiece);
            request.setRows_skip(pieceNum * recordsInPiece);
            pieceNum++;
            try{
                response = getStab().o_mdb_api_dog_list(request);
            }catch (Exception e){
                //todo
                //To make up what to do with the exception;
                System.out.println("Couldn't extract part number "+ pieceNum);
                e.printStackTrace();
            }
            if(response!=null){
                for (O_mdb_api_dog_list_return_row returnRow:response.get_return()){
                    contractList.add(new ApiRow2OContractAdapter(returnRow));
                }
            }

        }while (response!=null && response.isMore_rows());
        return contractList;
    }

    public  Map<Double,OContractAttribute> getSuppAttributeMap(OContract contract){
        Map<Double,OContractAttribute> contractAttributeMap = new HashMap<Double, OContractAttribute>();
        if(contract!=null){
            O_mdb_api_get_dog_get_add_dog_attr_list_request request = new O_mdb_api_get_dog_get_add_dog_attr_list_request();
            O_mdb_api_get_dog_get_add_dog_attr_list_response response=null;
            request.setPdogid(contract.getDogid());
            try {
                response = getStab().o_mdb_api_get_dog_get_add_dog_attr_list(request);
                for (T_o_mdb_tt_add_attr_row row:response.get_return()){
                    OContractAttribute oContractAttribute=buildByRow(row);
                    if (oContractAttribute!=null){
                        contractAttributeMap.put(oContractAttribute.getId(), oContractAttribute);
                    }
                }
            }catch (RemoteException e){
            }
        }
        return contractAttributeMap;
    }








    private OContractAttribute buildByRow(T_o_mdb_tt_add_attr_row row){
        OContractAttribute oContractAttribute=null;
        if (row!=null){
            oContractAttribute=new OContractAttribute();
            oContractAttribute.setId(row.getId());
            oContractAttribute.setName(row.getName());
            oContractAttribute.setType(row.getType());
            oContractAttribute.setValue(row.getValue());
        }
        return oContractAttribute;
    }
//    o_mdb_api_get_dog_get_add_dog_attr_list_request


    public List<OContract> findByAttributeValue(Double attrId, String attrValue){
        List<OContract> contractList = new ArrayList<OContract>();
        O_mdb_api_get_dog_get_dogid_by_attr_request request = new O_mdb_api_get_dog_get_dogid_by_attr_request();
        O_mdb_api_get_dog_get_dogid_by_attr_response response=null;
        try{
            response = getStab().o_mdb_api_get_dog_get_dogid_by_attr(request);
            for(T_o_mdb_tt_num_row row:response.get_return()){
                OContract contract = findById(row.getColumn_value());
                contractList.add(contract);
            }

        }catch (Exception e){

        }
        return contractList;
    }


    @Override
    public DataChunk<OContract> findPatternPartly(String dogCode,int rowsLimit,int rowsSkip ){
        O_mdb_api_dog_list_request request=new O_mdb_api_dog_list_request();

        T_dogcode_2 t_dogcode_2=new T_dogcode_2();
        t_dogcode_2.setLike(dogCode+"%");

        T_utid_1 t_utid_1=new T_utid_1();
        t_utid_1.setIs_not(OContract.Type.RASHOD.getUtid());

        T_status_1 t_status_1=new T_status_1();
        t_status_1.setIs_not(Status.DELETED.getId());

        request.setUtid(t_utid_1);
        request.setDogcode(t_dogcode_2);
        request.setStatus(t_status_1);

        DataChunk<OContract> contractList = new DataChunk<OContract>();
        O_mdb_api_dog_list_response response= null;
            request.setRows_limit(rowsLimit);
            request.setRows_skip(rowsSkip);
            try{
                response = getStab().o_mdb_api_dog_list(request);
                contractList.setChunkNum(rowsSkip/rowsLimit);
                contractList.setTheLastChunk(!response.isMore_rows());
                for (O_mdb_api_dog_list_return_row returnRow:response.get_return()){
                    contractList.add(new ApiRow2OContractAdapter(returnRow));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        return contractList;
    }
}
