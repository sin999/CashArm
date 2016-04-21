package cashArm.onyma.Services;

import cashArm.onyma.DAO.Exceptions.UnexpectedCountResults;
import cashArm.onyma.DAO.OContractDAO;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.OnymaPayments.PaymentTransactionParam2SimplePaymentAdapter;
import cashArm.onyma.OnymaPayments.PaymentTransactionParams;

import cashArm.Common.OEntityes.SimplePayment;
import cashArm.Common.OEntityes.main.OContract;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.12.13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */

@Named("paymentService")
public class PaymentService {
    @Inject
    private PaymentDAO paymentDAO;
    @Inject
    private OContractDAO oContractDAO;
    public SimplePayment createPaymentByParams(PaymentTransactionParams transactionParams) throws NoContractFoundException{
        OContract oContract=null;
        String message=null;
        try {
            oContract = oContractDAO.findByCode(transactionParams.getNumber());
        } catch (UnexpectedCountResults e){
            String err="<CONTRACT_DAO_ERROR><MESSAGE>MORE THEN ONE CONTRACTS HAVE BEEN FOUND FOR THIS CODE</MESSAGE><CONTRACT_CODE>"+transactionParams.getNumber()+"</CONTRACT_CODE></CONTRACT_DAO_ERROR>";
            message=message==null?err:message+""+err;
        }
        if (oContract==null){
            String errMess=message!=null?message:"<CONTRACT_DAO_ERROR><MESSAGE>CONTRACT NOT FOUND</MESSAGE><CONTRACT_CODE>"+transactionParams.getNumber()+"</CONTRACT_CODE></CONTRACT_DAO_ERROR>";
            throw  new NoContractFoundException(errMess);
        }
        return new PaymentTransactionParam2SimplePaymentAdapter(oContract,transactionParams);
    }
}
