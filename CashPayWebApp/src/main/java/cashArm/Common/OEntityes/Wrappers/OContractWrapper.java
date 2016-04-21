package cashArm.Common.OEntityes.Wrappers;



import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 8:51
 * To change this template use File | Settings | File Templates.
 */
public class OContractWrapper extends OContract implements Serializable {
    private OContract contract;
    public OContractWrapper(OContract contract){
        this.contract=contract;
    }

    @Override
    public Double getBill() {
        return contract.getBill();
    }

    @Override
    public Calendar getClose_billing_date() {
        return contract.getClose_billing_date();
    }

    @Override
    public Double getCsid() {
        return contract.getCsid();
    }

    @Override
    public String getDogcode() {
        return contract.getDogcode();
    }

    @Override
    public Double getDogid() {
        return contract.getDogid();
    }

    @Override
    public Double getDogidup() {
        return contract.getDogidup();
    }

    @Override
    public Double getDognum() {
        return contract.getDognum();
    }

    @Override
    public Calendar getEnddate() {
        return contract.getEnddate();
    }

    @Override
    public Double getGid() {
        return contract.getGid();
    }

    @Override
    public Double getOrgid() {
        return contract.getOrgid();
    }

    @Override
    public Double getParent_orgid() {
        return contract.getParent_orgid();
    }

    @Override
    public Calendar getStartdate() {
        return contract.getStartdate();
    }

    @Override
    public Double getStatus() {
        return contract.getStatus();
    }

    @Override
    public Calendar getStatus_date() {
        return contract.getStatus_date();
    }

    @Override
    public Double getTsid() {
        return contract.getTsid();
    }

    @Override
    public Double getUtid() {
        return contract.getUtid();
    }

    @Override
    public Double getWhomake() {
        return contract.getWhomake();
    }

    @Override
    public void setBill(Double bill) {
        contract.setBill(bill);
    }

    @Override
    public void setClose_billing_date(Calendar close_billing_date) {
        contract.setClose_billing_date(close_billing_date);
    }

    @Override
    public void setCsid(Double csid) {
        contract.setCsid(csid);
    }

    @Override
    public void setDogcode(String dogcode) {
        contract.setDogcode(dogcode);
    }

    @Override
    public void setDogid(Double dogid) {
        contract.setDogid(dogid);
    }

    @Override
    public void setDogidup(Double dogidup) {
        contract.setDogidup(dogidup);
    }

    @Override
    public void setDognum(Double dognum) {
        contract.setDognum(dognum);
    }

    @Override
    public void setEnddate(Calendar enddate) {
        contract.setEnddate(enddate);
    }

    @Override
    public void setGid(Double gid) {
        contract.setGid(gid);
    }

    @Override
    public void setOrgid(Double orgid) {
        contract.setOrgid(orgid);
    }

    @Override
    public void setParent_orgid(Double parent_orgid) {
        contract.setParent_orgid(parent_orgid);
    }

    @Override
    public void setStartdate(Calendar startdate) {
        contract.setStartdate(startdate);
    }

    @Override
    public void setStatus(Double status) {
        contract.setStatus(status);
    }

    @Override
    public void setStatus_date(Calendar status_date) {
        contract.setStatus_date(status_date);
    }

    @Override
    public void setTsid(Double tsid) {
        contract.setTsid(tsid);
    }

    @Override
    public void setUtid(Double utid) {
        contract.setUtid(utid);
    }

    @Override
    public void setWhomake(Double whomake) {
        contract.setWhomake(whomake);
    }
}
