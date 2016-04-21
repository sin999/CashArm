package cashArm.onyma.Services;

import cashArm.onyma.DAO.*;
import cashArm.onyma.DAO.Exceptions.UnexpectedCountResults;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.onyma.common.DataChunk;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */
@Named("contractService")
public class ContractService implements Serializable{
    @Inject
    private OAuthNameDAO authNameDAO;
    @Inject
    private OContractDAO oContractDAO;
    @Inject
    private OConnectionDAO oConnectionDAO;
    @Inject
    private OConnectionParameterDAO oConnectionParameterDAO;
    @Inject
    private OPersonalTariffDAO personalTariffDAO;
    @Inject
    private OBalanceDAO balanceDAO;
    @Inject
    private PaymentDAO paymentDAO;
    public OContract getFullContract(OContract oContractBody){
        return getFullContract(oContractBody.getDogcode());
    }

    public OContract getFullContract(String contractNumber){
       OContract contract=null;
        try {
            contract=oContractDAO.findByCode(contractNumber);
           if(contract!=null){
            contract.setContractAttributeMap(oContractDAO.getSuppAttributeMap(contract));
            contract.setPaymentList(paymentDAO.getPaymentList(contract));
            contract.setBalance(getCurrentBalance(contract));

            for (OAuthName authName:authNameDAO.getByContact(contract)){
                contract.getAuthNameList().add(authName);
                for (OConnection connection:oConnectionDAO.findByAuthName(authName)){
                    connection.setParameterMap(oConnectionParameterDAO.getParameterMap(connection));
                    authName.getConnectionList().add(connection);
                    connection.setPersonalTariffList(personalTariffDAO.getConnectionPersonalTariffList(connection));
                    connection.setTariff(personalTariffDAO.getTariffMap().get(connection.getTmid()));
                }
            }
           }

        } catch (UnexpectedCountResults e){
             System.out.println("There are more then one variant found for contract number "+ contractNumber);
        }
       return contract;
    }

    public String contract2XML(OContract contract){
            String xml="";
            try{
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                JAXBContext jaxbContext = JAXBContext.newInstance(OContract.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(contract,outputStream);
                xml = outputStream.toString();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return  xml;
    }


    public Double getCurrentBalance(OContract contract){
        return contract==null?null:getBalanceByDogCode(contract.getDogcode(),Calendar.getInstance());
    }
    public Double getBalanceByDogCode(String dogCode,Calendar date){

    Double balance=null;
    try {
            OContract contract=oContractDAO.findByCode(dogCode);
        if (contract!=null){
              balance  = balanceDAO.calculateBalanceOnLastDayOfMonthNew(contract, date);
        }else {
            System.out.println("Couldn't find contract "+ dogCode);
        }
    } catch (UnexpectedCountResults e){
        System.out.println("There are more then one variant found for contract number "+ dogCode);
    }
        return balance;
    }

    public Map<String,Double> getOBalanceMap(List<String> dogNumList,Calendar date){
        String fileName="c:\\bg4onyma\\balanceMapNew1.obj";
        Map<String,Double> balanceMap;
        balanceMap=restoreMap(fileName);
        if(balanceMap==null){
        balanceMap=new HashMap<String, Double>();
        int    index =0;
        for (String dogNum:dogNumList){
//            System.out.println("Adding contract "+ dogNum);
            balanceMap.put(dogNum,getBalanceByDogCode(dogNum,date));
//           if(index++>10) break;
        }
            saveMap(balanceMap,fileName);
        }
        return balanceMap;
    }

    private void saveMap(Map<String,Double> map,String fileName){
        try{
            FileOutputStream fos=new FileOutputStream(fileName);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(map);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private Map<String,Double> restoreMap(String fileName){
        Map<String,Double> map=null;
        try{
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            map =(Map<String,Double>)ois.readObject();
        }catch (Exception e){
           // e.printStackTrace();
        }
        return map;
    }

    public List<OContract> getListByPattern(String pattern){
        return  oContractDAO.findByCodePartRAW(pattern);
    }

    public DataChunk<OContract> getSkeletonListByPatternPartly(String pattern,int rowLimit,int rowSkip){
        return  oContractDAO.findPatternPartly(pattern, rowLimit, rowSkip);
    }

    public  DataChunk<OContract> getListByPatternPartly(String pattern,int rowLimit,int rowSkip){

        DataChunk<OContract> skeletones= getSkeletonListByPatternPartly(pattern, rowLimit, rowSkip);
        DataChunk<OContract> fullContractList= new  DataChunk<OContract>(skeletones.getChunkNum(),skeletones.isTheLastChunk());

        for(OContract oContract:skeletones){
            fullContractList.add(getFullContract(oContract));
        }
        return fullContractList;
    }


    public List<OConnection> getContractConnectionList(OContract contract){
        return oConnectionDAO.findByContract(contract);
    }

    public String test(){
        return "Tested, OK!";
    }
}
