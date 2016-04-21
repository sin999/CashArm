package cashArm.bbeans;

import cashArm.Contract4Search;
import cashArm.search_engine.Indexer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Admin on 25.08.14.
 */
@Named
@SessionScoped
public class ContractFinder implements Serializable{

    private Map<String,Contract4Search> itemsMap= new HashMap<String, Contract4Search>();
//    public List<String> completeMethod(String str){
//        List<String> offerList=new ArrayList<String>();
//        try {
//            Indexer indexer=new Indexer();
//            List<String> list=indexer.lookFor(str, "content");
//            offerList.addAll(list.size() < 10 ? list : list.subList(0, 10));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return offerList;
//    }

//    public List<Contract4Search> completeMethodObj(String str){
//        List<Contract4Search> offerList=new ArrayList<Contract4Search>();
//        try {
//            Indexer indexer=new Indexer();
//            List<Contract4Search> list=indexer.lookForObj(str, "content");
//            offerList=list.size() < 10 ? list : list.subList(0, 10);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return offerList;
//    }

    public List<String> completeMethod(String str){
        List<String> stringList=new ArrayList<String>();
        if (str!=null){
            try {
                Indexer indexer=new Indexer();
                List<Contract4Search> list=indexer.lookForObj((str.trim().equals("")?"":str+"*"), "content");
                list=list.size() < 10 ? list : list.subList(0, 10);
                getItemsMap().clear();
                for (Contract4Search contract4Search:list){
                    stringList.add(contract2String(contract4Search));
                    getItemsMap().put(contract2String(contract4Search),contract4Search);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return stringList;
    }


        public String contract2String(Contract4Search contract4Search){
            return contract4Search==null?"null":
                    contract4Search.getCode()+"  "+
                    contract4Search.getName()+"  "+
                    contract4Search.getAddress()+"  "+
                    contract4Search.getPhone()+"  ";
        }


    private Contract4Search target;

    public Contract4Search getTarget() {
        return target;
    }

    public void setTarget(Contract4Search target) {
        System.out.println(target==null?">>>>>>>>>>>>>>>>Target is null!!!":">>>>>>>>>>>>>>>>Target code is "+target.getCode());
        this.target = target;
    }

    public Map<String, Contract4Search> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<String, Contract4Search> itemsMap) {
        this.itemsMap = itemsMap;
    }

    public String getDogCode(String keyString){
        System.out.println("ge --------> "+((getItemsMap().get(keyString) == null)?null:getItemsMap().get(keyString).getCode()));
        return (getItemsMap().get(keyString) == null)?null:getItemsMap().get(keyString).getCode();
    }

}
