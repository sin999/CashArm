package cashArm.onyma.app;

//import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.12.13
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 */
public class MakeOnymaPayment {

//    public static void main(String[] args) {
//        ApplicationContext applicationContext=ApplicationContextFactory.getContext();
//        PaymentDAO paymentDAO=(PaymentDAO)applicationContext.getBean("paymentDAO");
//        PaymentService paymentService=(PaymentService)applicationContext.getBean("paymentService");
//        PaymentTransactionParams transactionParams;
//        Double paymentResult=null;
//        String mess=null;
//        try {
//            transactionParams = new PaymentTransactionParams(args);
//            try{
//                SimplePayment payment=paymentService.createPaymentByParams(transactionParams);
//                paymentResult=paymentDAO.makeSimplePayment(payment);
//            }catch (NoContractFoundException e){
//                mess=mess==null?e.getMessage():mess+"\n"+e.getMessage();
//            }
//        }catch (ParseException e){
//            mess=mess==null?e.getMessage():mess+"\n"+e.getMessage();
//        }
//
//        if (mess==null){
//            if (paymentResult!=null){
//                mess= "<RESULT>SUCCESS</RESULT>"+"<RESULT_CODE>"+String.format("%.0f",paymentResult)+"</RESULT_CODE>";
//            }else {
//                mess="<RESULT>FAILED</RESULT>"+"<RESULT_MESSAGE>"+"ONYMA HAS REJECTED PAYMENT BY UNKNOWN CAUSE"+"</RESULT_MESSAGE>"+"<RESULT_CODE>"+paymentResult+"</RESULT_CODE>";
//
//            }
//        }
//        String inputString="";
//        for(String arg:args){
//            inputString=inputString+" "+arg;
//        }
//        System.out.println("<ONYMA_API_TRANSACTION><DATE>"+new Date()+"</DATE>\n<INPUT_STRING>"+inputString+"</INPUT_STRING>\n"+mess+"\n</ONYMA_API_TRANSACTION>");
//
//
//    }



}
