package cashArm.Common.OEntityes;


import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.12.13
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class SimplePaymentImpl implements SimplePayment , Serializable {
        private OContract dog;
        private String txId;
        private Calendar txDate;
        private Double txAmount;
        private String comment;
    public SimplePaymentImpl(OContract contract){
        this.dog=contract;
    }
    @Override
    public OContract getDog() {
        return dog;
    }

    public void setDog(OContract dog) {
        this.dog = dog;
    }
    @Override
    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
    @Override
    public Calendar getTxDate() {
        return txDate;
    }

    public void setTxDate(Calendar txDate) {
        this.txDate = txDate;
    }
    @Override
    public Double getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(Double txAmount) {
        this.txAmount = txAmount;
    }
    @Override
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
