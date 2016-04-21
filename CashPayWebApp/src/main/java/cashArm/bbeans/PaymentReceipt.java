package cashArm.bbeans;

import cashArm.Common.OEntityes.SimplePayment;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.bbeans.wrapers.AbstractContractWrapper;
import cashArm.onyma.DAO.PaymentDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 15.08.14.
 */
public class PaymentReceipt implements SimplePayment {
    private final DateFormat timeStampDF=new SimpleDateFormat("yyyyMMddHHmmssZ");
    private final DateFormat dateDF=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private PaymentDAO paymentDAO;
    private boolean done;
    private OContract dog;
    private String txId="sss"+(new Date()).getTime();
    private Calendar txDate=Calendar.getInstance();
    private Double txAmount;
    private String comment;
    private Double paymentOnymaId;
    private Status status=Status.NEW;



    public enum Status{
        NEW,SUCCESSFUL,FAILED;
    }


    public PaymentReceipt(PaymentDAO paymentDAO,OContract oContract){
        this.paymentDAO=paymentDAO;
        setDog(oContract);
        setComment("п/п "+dateDF.format(new Date())+" Оплата по дог. "+oContract.getDogcode()+" через Касса ФЛ Зал (); pay system: 150; txn ID: "+timeStampDF.format(new Date()));
        setTxId(timeStampDF.format(new Date()));
    }


    public OContract getDog() {
        return dog;
    }

    public void setDog(OContract dog) {
        this.dog = dog;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Calendar getTxDate() {
        return txDate;
    }

    public void setTxDate(Calendar txDate) {
        this.txDate = txDate;
    }

    public Double getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(Double txAmount) {
        this.txAmount = txAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDone() {
        return done;
    }

    public void process(){
        paymentOnymaId=paymentDAO.makeSimplePayment(this);
        status=(paymentOnymaId==null)?Status.FAILED:Status.SUCCESSFUL;
        this.done=true;
    }

    public Double getPaymentOnymaId(){
        return paymentOnymaId;
    }

    public Status getStatus(){
        return status;
    }
}
