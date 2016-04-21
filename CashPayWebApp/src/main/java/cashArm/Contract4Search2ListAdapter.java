package cashArm;

import java.util.List;

/**
 * Created by Admin on 25.08.14.
 */
public class Contract4Search2ListAdapter extends Contract4Search{
    private List<String> list;
    private static int ID_OFFSET=0;
    private static int CODE_OFFSET=1;
    private static int NAME_OFFSET=2;
    private static int ADDRESS_OFFSET=3;
    private static int PHONE_OFFSET=4;
    private static int GROUP_OFFSET=5;


    public Contract4Search2ListAdapter(List<String> list){
        this.list=list;
    }

    @Override
    public String getId(){
        return getByIndex(ID_OFFSET);
    }

    @Override
    public String getCode(){
        return getByIndex(CODE_OFFSET);

    }

    @Override
    public String getName(){
        return getByIndex(NAME_OFFSET);

    }

    @Override
    public String getAddress(){
        return getByIndex(ADDRESS_OFFSET);

    }

    @Override
    public String getPhone(){
        return getByIndex(PHONE_OFFSET);
    }

    @Override
    public String getGroup(){
        return getByIndex(GROUP_OFFSET);

    }

    @Override
    public String getConnections(){
        return "";
    }

    private String getByIndex(int ind){
        return (list==null || list.size()<ind)?"":list.get(ind);
    }

}
