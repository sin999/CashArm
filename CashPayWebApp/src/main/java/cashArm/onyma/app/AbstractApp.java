//package cashArm.onyma.app;
//
//import cashArm.onyma.DAO.*;
//import cashArm.onyma.Services.ContractService;
//import cashArm.onyma.Services.IsgFixService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * Created with IntelliJ IDEA.
// * User: Admin
// * Date: 06.03.14
// * Time: 14:55
// * To change this template use File | Settings | File Templates.
// */
//public class AbstractApp {
//    private OConnectionDAO connectionDAO;
//    private ApplicationContext applicationContext;
//    private OContractDAO oContractDAO;
//    private PaymentDAO paymentDAO;
//    private ContractService contractService;
//    private ApplicationContext context;
//    private OAuthNameDAO authNameDAO;
//    private IsgFixService isgFixService;
//    private OAuthNameDAO oAuthNameDAO;
//    private OBalanceDAO balanceDAO;
//    private OContractBasicAttributeDAO basicAttributeDAO;
//
//    AbstractApp(){
//        applicationContext= ApplicationContextFactory.getContext();
//        oContractDAO=(OContractDAO)applicationContext.getBean("oContractDAO") ;
//        paymentDAO=(PaymentDAO)applicationContext.getBean("paymentDAO");
//        authNameDAO=(OAuthNameDAO)applicationContext.getBean("authNameDAO");
//        contractService=(ContractService)applicationContext.getBean("contractService");
//        connectionDAO = (OConnectionDAO)applicationContext.getBean("oConnectionDAO");
//        oAuthNameDAO = (OAuthNameDAO)applicationContext.getBean("authNameDAO");
//        balanceDAO = (OBalanceDAO)applicationContext.getBean("balanceDAO");
//        basicAttributeDAO = (OContractBasicAttributeDAO)applicationContext.getBean("oContractBasicAttributeDAO");
//
//    }
//
//    public OConnectionDAO getConnectionDAO() {
//        return connectionDAO;
//    }
//
//    public ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    public OContractDAO getoContractDAO() {
//        return oContractDAO;
//    }
//
//    public PaymentDAO getPaymentDAO() {
//        return paymentDAO;
//    }
//
//    public ContractService getContractService() {
//        return contractService;
//    }
//
//    public ApplicationContext getContext() {
//        return context;
//    }
//
//    public OAuthNameDAO getAuthNameDAO() {
//        return authNameDAO;
//    }
//
//    public IsgFixService getIsgFixService() {
//        return isgFixService;
//    }
//
//    public OAuthNameDAO getoAuthNameDAO() {
//        return oAuthNameDAO;
//    }
//
//    public OBalanceDAO getBalanceDAO() {
//        return balanceDAO;
//    }
//
//    public OContractBasicAttributeDAO getBasicAttributeDAO() {
//        return basicAttributeDAO;
//    }
//}
