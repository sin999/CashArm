package cashArm.Common.OEntityes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.07.14.
 */
public class IpSubnet  implements Serializable {
    private static final int ipAddressMask=0xFFFFFFFF;
    private Long addr;
    private int hostBits=32;

    public IpSubnet(){}
    public IpSubnet(String addr){

        if(addr!=null){
            String[] splitedAddress=addr.split("/");
            if (splitedAddress.length>1){

                setAddr(splitedAddress[0]);
                int mask=32;
                try{
                    mask=Integer.valueOf(splitedAddress[1]);
                }catch ( NumberFormatException e){

                }
                setMask((mask>32 ||mask<16)?32:mask);
            }else{
                System.out.println(" split address is"+ip2string(string2ip(splitedAddress[0])));
                setAddr(splitedAddress[0]);
                setMask(32);
            }
        }
    }
    public IpSubnet(String addr,String mask){
        setAddr(addr);
        setMask(Integer.valueOf(mask));
    }

    public void setAddr(String addr) {
        this.addr = string2ip(addr);
    }

    public void setMask(int mask) {
        this.hostBits = mask;
    }

    public String getAddr() {
        return ip2string(addr);
    }

    public int getMask() {
        return hostBits;
    }

    public List<String> getAddrList(){
        List<String> retValue=new ArrayList<String>();
        if(getSubnetAddress()!=null && getBroadcastAddress()!=null){
            for(long curAddr=getSubnetAddress();curAddr<=getBroadcastAddress();curAddr++){
                retValue.add(ip2string(curAddr));
            }
        }
        return retValue;
    }

    public int getPlainMask(){
        return (ipAddressMask&(ipAddressMask<<(32-hostBits)));
    }

    public Long getSubnetAddress(){
        Long retValue=null;
        if (addr!=null){
            retValue=getPlainMask()&addr;
        }
        return retValue;
    }


    public Long getBroadcastAddress(){
        Long retValue=null;
        if (addr!=null){
            retValue=(addr|(getPlainMask()^ipAddressMask));
        }
        return retValue;
    }
    private String ip2string(Long ip){
        String retValue=null;
        if (ip!=null){
            long i=ip;

            retValue = ""+((i >> 24 ) & 0xFF) + "." +
                    ((i >> 16 ) & 0xFF) + "." +
                    ((i >>  8 ) & 0xFF) + "." +
                    ( i        & 0xFF);
        }
        return retValue;
    }

    private Long string2ip(String dottedIP){
        Long retValue=null;
        if (dottedIP!=null){
            String[] addrArray = dottedIP.split("\\.");

            long num = 0;
            for (int i=0;i<addrArray.length;i++) {
                int power = 3-i;
                num += ((Integer.parseInt(addrArray[i]) % 256) * Math.pow(256,power));
//                System.out.println(" Octet "+addrArray[i]+" result = "+Math.pow(256,power));
            }
            retValue=num;
        }
        return retValue;
    }
}
