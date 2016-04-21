package cashArm.onyma.OnymaPayments;


import cashArm.Common.OEntityes.SimplePayment;
import cashArm.Common.OEntityes.main.OContract;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.12.13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class PaymentTransactionParam2SimplePaymentAdapter implements SimplePayment {
    private OContract contract;
    private PaymentTransactionParams params;
    public PaymentTransactionParam2SimplePaymentAdapter(OContract contract,PaymentTransactionParams params){
        this.contract=contract;
        this.params=params;
    }

    @Override
    public OContract getDog() {
        return contract;
    }

    @Override
    public String getTxId() {
        return params.getReceipt();
    }

    @Override
    public Calendar getTxDate() {
        return params.getDate();
    }

    @Override
    public Double getTxAmount() {
        return params.getAmount();
    }

    @Override
    public String getComment() {
        return params.getComment();
    }
}
