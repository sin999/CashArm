package cashArm.bbeans;

import cashArm.Common.OEntityes.main.OContract;
import cashArm.bbeans.wrapers.AbstractContractWrapper;
import cashArm.onyma.DAO.PaymentDAO;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 15.08.14.
 */
@Named
public class PaymentFactory implements Serializable{
    @Inject
    private PaymentDAO paymentDAO;

    public PaymentReceipt newPayment(OContract oContract){
        PaymentReceipt paymentReceipt=new PaymentReceipt(paymentDAO,oContract);
        paymentReceipt.setDog(oContract);
        return paymentReceipt;
    }

}
