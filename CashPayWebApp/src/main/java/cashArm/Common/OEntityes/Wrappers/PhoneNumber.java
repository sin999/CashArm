package cashArm.Common.OEntityes.Wrappers;

import java.io.Serializable;

/**
 * Created by Admin on 18.07.14.
 */
public class PhoneNumber  implements Serializable {

    public static PhoneNumber buildByOnymaData(String onymaNumber){
//        2934454@347
        PhoneNumber phoneNumber=null;
        if (onymaNumber!=null){
            String[] arr=onymaNumber.split("@");
            phoneNumber=new PhoneNumber();
            if(arr.length>0){
                phoneNumber.setStringNumber(arr[0]);
                if(arr.length>1){
                    phoneNumber.setStringPrefix(arr[1]);
                }
            }
        }
        return phoneNumber;
    }

    private Integer number;
    private Integer prefix;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    public String getStringNumber() {
        return number==null?null:String.valueOf(getNumber());
    }

    public void setStringNumber(String number) {
        try {
            setNumber(Integer.parseInt(number));
        }catch (NumberFormatException e){}

    }

    public String getStringPrefix() {
        return number==null?null:String.valueOf(getPrefix());
    }

    public void setStringPrefix(String prefix) {
        try {
            setPrefix(Integer.parseInt(prefix));
        }catch (NumberFormatException e){}
    }
}
