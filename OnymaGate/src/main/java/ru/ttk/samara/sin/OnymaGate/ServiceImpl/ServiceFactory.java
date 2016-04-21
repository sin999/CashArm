package ru.ttk.samara.sin.OnymaGate.ServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Admin on 16.06.14.
 */
public class ServiceFactory {
    private static ApplicationContext applicationContext;
    public static ApplicationContext getApplicationContext(){
        if (applicationContext==null){
            applicationContext  = new ClassPathXmlApplicationContext("/spring/application-context.xml");
        }
        return applicationContext;
    }

    public static PaymentService getPaymentService() throws Exception{
        PaymentService paymentService=null;
        try{
            paymentService = (PaymentService)getApplicationContext().getBean("paymentService");
        }catch (Exception e){
            throw new Exception("An exception was caught while Spring context beeing used for the payment service.");
        }
        return paymentService;
    }

    public static String test(){
        return "test spring!";
    }
}
