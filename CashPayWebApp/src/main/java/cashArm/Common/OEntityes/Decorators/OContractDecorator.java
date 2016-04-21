package cashArm.Common.OEntityes.Decorators;


import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 13.02.14
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class OContractDecorator extends OContract implements Serializable {
    OContract oContract;
    public OContractDecorator(OContract oContract) {
     this.oContract=oContract;
    }

    @Override
    public Double getBill() {
        return oContract.getBill();
    }

    @Override
    public Calendar getClose_billing_date() {
        return oContract.getClose_billing_date();
    }

    @Override
    public Double getCsid() {
        return oContract.getCsid();
    }

    @Override
    public String getDogcode() {
        return oContract.getDogcode();
    }

    @Override
    public Double getDogid() {
        return oContract.getDogid();
    }

    @Override
    public Double getDogidup() {
        return oContract.getDogidup();
    }

    @Override
    public Double getDognum() {
        return oContract.getDognum();
    }

    @Override
    public Calendar getEnddate() {
        return oContract.getEnddate();
    }

    @Override
    public Double getGid() {
        return oContract.getGid();
    }

    @Override
    public Double getOrgid() {
        return oContract.getOrgid();
    }

    @Override
    public Double getParent_orgid() {
        return oContract.getParent_orgid();
    }

    @Override
    public Calendar getStartdate() {
        return oContract.getStartdate();
    }

    @Override
    public Double getStatus() {
        return oContract.getStatus();
    }

    @Override
    public Calendar getStatus_date() {
        return oContract.getStatus_date();
    }

    @Override
    public Double getTsid() {
        return oContract.getTsid();
    }

    @Override
    public Double getUtid() {
        return oContract.getUtid();
    }

    @Override
    public Double getWhomake() {
        return oContract.getWhomake();
    }

    @Override
    public void setBill(Double bill) {
        oContract.setBill(bill);
    }

    @Override
    public void setClose_billing_date(Calendar close_billing_date) {
        oContract.setClose_billing_date(close_billing_date);
    }

    @Override
    public void setCsid(Double csid) {
        oContract.setCsid(csid);
    }

    @Override
    public void setDogcode(String dogcode) {
        oContract.setDogcode(dogcode);
    }

    @Override
    public void setDogid(Double dogid) {
        oContract.setDogid(dogid);
    }

    @Override
    public void setDogidup(Double dogidup) {
        oContract.setDogidup(dogidup);
    }

    @Override
    public void setDognum(Double dognum) {
        oContract.setDognum(dognum);
    }

    @Override
    public void setEnddate(Calendar enddate) {
        oContract.setEnddate(enddate);
    }

    @Override
    public void setGid(Double gid) {
        oContract.setGid(gid);
    }

    @Override
    public void setOrgid(Double orgid) {
        oContract.setOrgid(orgid);
    }

    @Override
    public void setParent_orgid(Double parent_orgid) {
        oContract.setParent_orgid(parent_orgid);
    }

    @Override
    public void setStartdate(Calendar startdate) {
        oContract.setStartdate(startdate);
    }

    @Override
    public void setStatus(Double status) {
        oContract.setStatus(status);
    }

    @Override
    public void setStatus_date(Calendar status_date) {
        oContract.setStatus_date(status_date);
    }

    @Override
    public void setTsid(Double tsid) {
        oContract.setTsid(tsid);
    }

    @Override
    public void setUtid(Double utid) {
        oContract.setUtid(utid);
    }

    @Override
    public void setWhomake(Double whomake) {
        oContract.setWhomake(whomake);
    }
}
