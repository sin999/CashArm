package cashArm.onyma.DAO;


import cashArm.Common.OEntityes.main.OContract;
import cashArm.onyma.DAO.Adapters.ApiRow2Payment;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_dogpayment_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_dogpayment_response;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_pay_gate_add_pay_request;
import ru.onyma.www.services.OnymaApi.funcs.O_mdb_api_pay_gate_add_pay_response;
import cashArm.Common.OEntityes.SimplePayment;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_dogpayment_return_row;
import ru.onyma.www.services.OnymaApi.types.T_dogid_1;

import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.12.13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */

@Named("paymentDAO")
public class PaymentDAO extends AbstractDAO implements Serializable{

    private Double makePayment(O_mdb_api_pay_gate_add_pay_request paymentRequest){
        O_mdb_api_pay_gate_add_pay_response response=null;
//        System.out.println("#########################\n"+paymentRequest.+"\n################################");
        try{
            response = getStab().o_mdb_api_pay_gate_add_pay(paymentRequest);
        }catch (Exception e){
            //todo
            //To make up what to do with the exception;
            System.out.println("Couldn't PaymentDAO.makePayment");
            e.printStackTrace();
        }
        return response==null?null:response.get_return();
    }

    public Double makeSimplePayment(SimplePayment payment){
        O_mdb_api_pay_gate_add_pay_request paymentRequest=getPaymentRequestBySimplePayment(payment);
//       return null;
        return makePayment(paymentRequest);
    }

    private O_mdb_api_pay_gate_add_pay_request getPaymentRequestBySimplePayment(SimplePayment payment){
        O_mdb_api_pay_gate_add_pay_request paymentRequest=new  O_mdb_api_pay_gate_add_pay_request();
        paymentRequest.setPdogid(payment.getDog().getDogid());
        paymentRequest.setPdate(payment.getTxDate());
        paymentRequest.setPsum(payment.getTxAmount());
        paymentRequest.setPremark(payment.getComment());
        paymentRequest.setPtxn_id(payment.getTxId());
//        paymentRequest.setPppid(200.0); //Идетификатор банковского счета (отчет банковские счета из онимы)
        paymentRequest.setPppid(163.0); //Новая Онима!!!! Идетификатор банковского счета (отчет банковские счета из онимы)
        return paymentRequest;
    }

    public List<SimplePayment> getPaymentList(OContract oContract){
        List<SimplePayment> payments=new ArrayList<SimplePayment>();
        if (oContract!=null){
            O_mdb_api_dogpayment_request request = new O_mdb_api_dogpayment_request();
            O_mdb_api_dogpayment_response response=null;
            T_dogid_1 t_dogid_1=new T_dogid_1();
            t_dogid_1.setIs(oContract.getDogid());
            request.setDogid(t_dogid_1);
            try{
                response = getStab().o_mdb_api_dogpayment(request);
                for(O_mdb_api_dogpayment_return_row row:response.get_return()){
                    if(row!=null){
                        payments.add(new ApiRow2Payment(row));
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return orderByDate(payments);
    }

    private List<SimplePayment> orderByDate(List<SimplePayment> list){
        TreeMap<Calendar,SimplePayment> treeMap=null;
        if(list!=null){
            treeMap=new TreeMap<Calendar, SimplePayment>();
            for(SimplePayment simplePayment:list){
                if(simplePayment!=null && simplePayment.getTxDate()!=null){
                    treeMap.put(simplePayment.getTxDate(),simplePayment);
                }
            }
        }
        return treeMap==null?null:(new ArrayList<SimplePayment>(treeMap.descendingMap().values()));
    }

}
