package cashArm.onyma.DAO.Adapters;

import ru.onyma.www.services.OnymaApi.types.O_mdb_api_dog_list_return_row;
import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.12.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class ApiRow2OContractAdapter extends OContract implements Serializable {
    private O_mdb_api_dog_list_return_row dogListRow;
    public ApiRow2OContractAdapter(O_mdb_api_dog_list_return_row dogListRow){
        this.dogListRow=dogListRow;
    }

    @Override
    public Double getDogid() {
        return dogListRow.getDogid();
    }

    public void setDogid(Double dogid) {
        dogListRow.setDogid(dogid);
    }

    @Override
    public Double getDognum() {
        return dogListRow.getDognum();
    }

    public void setDognum(Double dognum) {
        dogListRow.setDognum(dognum);
    }

    @Override
    public Calendar getStartdate() {
        return dogListRow.getStartdate();
    }

    public void setStartdate(Calendar startdate) {
        dogListRow.setStartdate(startdate);
    }

    public Calendar getEnddate() {
        return dogListRow.getEnddate();
    }

    public void setEnddate(Calendar enddate) {
        dogListRow.setEnddate(enddate);
    }

    public Double getBill() {
        return dogListRow.getBill();
    }

    public void setBill(Double bill) {
        dogListRow.setBill(bill);
    }

    public Double getGid() {
        return dogListRow.getGid();
    }

    public void setGid(Double gid) {
        dogListRow.setGid(gid);
    }

    public String getDogcode() {
        return dogListRow.getDogcode();
    }

    public void setDogcode(String dogcode) {
        dogListRow.setDogcode(dogcode);
    }

    public Double getStatus() {
        return dogListRow.getStatus();
    }

    public void setStatus(Double status) {
        dogListRow.setStatus(status);
    }

    public Calendar getStatus_date() {
        return dogListRow.getStatus_date();
    }

    public void setStatus_date(Calendar status_date) {
        dogListRow.setStatus_date(status_date);
    }

    public Double getOrgid() {
        return dogListRow.getOrgid();
    }

    public void setOrgid(Double orgid) {
        dogListRow.setOrgid(orgid);
    }

    public Double getParent_orgid() {
        return dogListRow.getParent_orgid();
    }

    public void setParent_orgid(Double parent_orgid) {
        dogListRow.setParent_orgid(parent_orgid);
    }

    public Double getDogidup() {
        return dogListRow.getDogidup();
    }

    public void setDogidup(Double dogidup) {
        dogListRow.setDogidup(dogidup);
    }

    public Calendar getClose_billing_date() {
        return dogListRow.getClose_billing_date();
    }

    public void setClose_billing_date(Calendar close_billing_date) {
        dogListRow.setClose_billing_date(close_billing_date);
    }

    public Double getWhomake() {
        return dogListRow.getWhomake();
    }

    public void setWhomake(Double whomake) {
        dogListRow.setWhomake(whomake);
    }

    public Double getTsid() {
        return dogListRow.getTsid();
    }

    public void setTsid(Double tsid) {
        dogListRow.setTsid(tsid);
    }

    public Double getCsid() {
        return dogListRow.getCsid();
    }

    public void setCsid(Double csid) {
        dogListRow.setCsid(csid);
    }

    public Double getUtid() {
        return dogListRow.getUtid();
    }

    public void setUtid(Double utid) {
        dogListRow.setUtid(utid);
    }
}
