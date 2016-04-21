package cashArm.bbeans.wrapers;

import cashArm.Common.OEntityes.ConstantsNew.ODogAttributes;
import cashArm.Common.OEntityes.SimplePayment;
import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OContract;
import cashArm.Common.OEntityes.main.OContractAttribute;
import cashArm.bbeans.PaymentReceipt;
import cashArm.onyma.DAO.PaymentDAO;
import cashArm.onyma.Services.ContractService;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 14.08.14.
 */

public abstract class AbstractContractWrapper extends OContract {
    private PaymentDAO paymentDAO;
    private OContract oContract;
    private PaymentReceipt paymentReceipt;
    private ContractService contractService;
    AbstractContractWrapper(OContract oContract,PaymentDAO paymentDAO,ContractService contractService){
        this.oContract=oContract;
        this.paymentDAO=paymentDAO;
        this.contractService=contractService;
    }

//    public static AbstractContractWrapper getContract(OContract oContract,PaymentDAO paymentDAO){
//        AbstractContractWrapper abstractContractWrapper=null;
//        if (oContract!=null){
//            switch (UTID.getByCode(oContract.getUtid())){
//                case UL: abstractContractWrapper= new ULContract(oContract,paymentDAO);
//                case FL: abstractContractWrapper= new FLContract(oContract,paymentDAO);
//                default: abstractContractWrapper= new FLContract(oContract,paymentDAO);
//            }
//        }
//        return abstractContractWrapper;
//    }


    public abstract boolean isFl();

    public abstract String getAgentName();

    public abstract String getAgentAddress();

    public String renewContract(){
        System.out.println("Before looking for contract (Wrapper reset)");
        this.oContract=contractService.getFullContract(oContract.getDogcode());
        return "done";
    }

    public PaymentReceipt getPayment() {
        if (paymentReceipt==null){
            paymentReceipt=new PaymentReceipt(paymentDAO,oContract);
        }
        return paymentReceipt;
    }

    public void commitPayment(){
        paymentReceipt=null;
    }

    public FLContract getFLContract(){
        return (FLContract)this;
    }

    public ULContract getULContract(){
        return (ULContract)this;
    }

    @Override
    public List<OConnection> getConnectionList() {
        return oContract.getConnectionList();
    }

    @Override
    public Double getBalance() {
        return oContract.getBalance();
    }

    @Override
    public List<SimplePayment> getPaymentList() {
        return oContract.getPaymentList();
    }

    @Override
    public List<OAuthName> getAuthNameList() {
        return oContract.getAuthNameList();
    }

    @Override
    public void setAuthNameList(List<OAuthName> authNameList) {
        oContract.setAuthNameList(authNameList);
    }

    @Override
    public Double getDogid() {
        return oContract.getDogid();
    }

    @Override
    public void setDogid(Double dogid) {
        oContract.setDogid(dogid);
    }

    @Override
    public Double getDognum() {
        return oContract.getDognum();
    }

    @Override
    public void setDognum(Double dognum) {
        oContract.setDognum(dognum);
    }

    @Override
    public Calendar getStartdate() {
        return oContract.getStartdate();
    }

    @Override
    public void setStartdate(Calendar startdate) {
        oContract.setStartdate(startdate);
    }

    @Override
    public Calendar getEnddate() {
        return oContract.getEnddate();
    }

    @Override
    public void setEnddate(Calendar enddate) {
        oContract.setEnddate(enddate);
    }

    @Override
    public Double getBill() {
        return oContract.getBill();
    }

    @Override
    public void setBill(Double bill) {
        oContract.setBill(bill);
    }

    @Override
    public Double getGid() {
        return oContract.getGid();
    }

    @Override
    public void setGid(Double gid) {
        oContract.setGid(gid);
    }

    @Override
    public String getDogcode() {
        return oContract.getDogcode();
    }

    @Override
    public void setDogcode(String dogcode) {
        oContract.setDogcode(dogcode);
    }

    @Override
    public Double getStatus() {
        return oContract.getStatus();
    }

    @Override
    public void setStatus(Double status) {
        oContract.setStatus(status);
    }

    @Override
    public Calendar getStatus_date() {
        return oContract.getStatus_date();
    }

    @Override
    public void setStatus_date(Calendar status_date) {
        oContract.setStatus_date(status_date);
    }

    @Override
    public Double getOrgid() {
        return oContract.getOrgid();
    }

    @Override
    public void setOrgid(Double orgid) {
        oContract.setOrgid(orgid);
    }

    @Override
    public Double getDogidup() {
        return oContract.getDogidup();
    }

    @Override
    public void setDogidup(Double dogidup) {
        oContract.setDogidup(dogidup);
    }

    @Override
    public Double getParent_orgid() {
        return oContract.getParent_orgid();
    }

    @Override
    public void setParent_orgid(Double parent_orgid) {
        oContract.setParent_orgid(parent_orgid);
    }

    @Override
    public Calendar getClose_billing_date() {
        return oContract.getClose_billing_date();
    }

    @Override
    public void setClose_billing_date(Calendar close_billing_date) {
        oContract.setClose_billing_date(close_billing_date);
    }

    @Override
    public Double getWhomake() {
        return oContract.getWhomake();
    }

    @Override
    public void setWhomake(Double whomake) {
        oContract.setWhomake(whomake);
    }

    @Override
    public Double getTsid() {
        return oContract.getTsid();
    }

    @Override
    public void setTsid(Double tsid) {
        oContract.setTsid(tsid);
    }

    @Override
    public Double getCsid() {
        return oContract.getCsid();
    }

    @Override
    public void setCsid(Double csid) {
        oContract.setCsid(csid);
    }

    @Override
    public Double getUtid() {
        return oContract.getUtid();
    }

    @Override
    public void setUtid(Double utid) {
        oContract.setUtid(utid);
    }

    @Override
    public Map<Double, OContractAttribute> getContractAttributeMap() {
        return oContract.getContractAttributeMap();
    }

    @Override
    public void setContractAttributeMap(Map<Double, OContractAttribute> contractAttributeMap) {
        oContract.setContractAttributeMap(contractAttributeMap);
    }

    protected String getProperty(ODogAttributes attribute){
        String value="";
        if (getContractAttributeMap()!=null && getContractAttributeMap().size()>0){
            value = getContractAttributeMap().get(attribute.getId())==null?"":getContractAttributeMap().get(attribute.getId()).getValue();
        }
        return value;
    }
}
