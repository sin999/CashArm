//package cashArm.onyma.app;
//
//import cashArm.onyma.Services.ContractService;
//import org.springframework.context.ApplicationContext;
//import cashArm.Common.OEntityes.Constants.OResources;
//import cashArm.Common.OEntityes.main.OConnection;
//import cashArm.Common.OEntityes.main.OContract;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created with IntelliJ IDEA.
// * User: Admin
// * Date: 21.02.14
// * Time: 10:09
// * To change this template use File | Settings | File Templates.
// */
//public class ContractDaoTest {
//    private static String PODKL_NE="11569";
//    String DEFAULT_CID="99F99999";
////    public static String contractId="631003709";
//    public static String contractId="021104281";
//    public static String contractPhoneId="021170375";
//    public static String contractIdRealIP="021104826";
//    public static String contractIdRealIP2="631000710";
//    public static String contractIdRealIP1="021180015";
////    public static String contractId="581616160";
////    public static String contractId="021180899";
//
////    private ApplicationContext applicationContext;
//    private ContractService contractService;
//
//    public static void main(String[] args) {
//        ContractDaoTest test=new ContractDaoTest();
//        test.doWorkPhone();
////        test.connCounter();
////           test.doWork1();
////        test.listTest();
//               }
//    public ContractDaoTest(){
//     init();
//    }
//
//    private void doWork(){
//        OContract contract=contractService.getFullContract(contractId);
//        System.out.println(contractService.contract2XML(contract));
//    }
//
//
//    private void doWorkRealIP(){
//        OContract contract=contractService.getFullContract(contractIdRealIP1);
//        System.out.println(contractService.contract2XML(contract));
//    }
//    private void doWorkPhone(){
//        OContract contract=contractService.getFullContract(contractPhoneId);
//        System.out.println(contractService.contract2XML(contract));
//    }
//
//
//
////    private void init(){
////        applicationContext= ApplicationContextFactory.getContext();
////        contractService=(ContractService)applicationContext.getBean("contractService");
////    }
//
//
//
//
//    private void connCounter(){
//        Map<OResources,Integer> countersMap=new HashMap<OResources, Integer>();
//        for (OContract contract:contractService.getListByPattern("0211%")){
//            System.out.println("Processing  "+contract.getDogcode());
//            for(OConnection connection:contractService.getContractConnectionList(contract)){
//                OResources resource= OResources.getByCode(connection.getService());
//                if (countersMap.keySet().contains(resource)){
//                    countersMap.put(resource, countersMap.get(resource) == null ? 1 : countersMap.get(resource) + 1);
//                }
//                else {
//                    countersMap.put(resource,1);
//
//                }
//            }
//        }
//
//        for(OResources resource:countersMap.keySet()){
//            System.out.println(resource.name()+" ID "+resource.getId()+" count "+countersMap.get(resource));
//        }
//    }
//
//
//
//
//
//}
