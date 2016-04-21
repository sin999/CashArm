package cashArm.onyma.app;


import cashArm.Common.OEntityes.IpSubnet;

/**
 * Created by Admin on 17.07.14.
 */
public class IpAddrTesting {
    public static void main(String[] args) {
//        IpSubnet ipSubnet = new IpSubnet("10.10.20.33/24");
        IpSubnet ipSubnet = new IpSubnet("164.138.33.1");
        System.out.println(ipSubnet.getSubnetAddress());
        System.out.println(ipSubnet.getBroadcastAddress());
        System.out.println("Address"+ipSubnet.getAddr());
        for(String ip:ipSubnet.getAddrList()){
            System.out.println(ip);
        }
    }
}
