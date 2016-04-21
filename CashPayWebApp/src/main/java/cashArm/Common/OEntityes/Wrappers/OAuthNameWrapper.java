package cashArm.Common.OEntityes.Wrappers;


import cashArm.Common.OEntityes.main.OAuthName;
import cashArm.Common.OEntityes.main.OConnection;
import cashArm.Common.OEntityes.main.OContract;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.02.14
 * Time: 8:51
 * To change this template use File | Settings | File Templates.
 */
public class OAuthNameWrapper extends OAuthName implements Serializable {
    private OAuthName authName;
    public OAuthNameWrapper(OAuthName authName){
        super(authName.getContract());
        this.authName=authName;
    }

    @Override
    public Double getBill() {
        return authName.getBill();
    }

    @Override
    public List<OConnection> getConnectionList() {
        return authName.getConnectionList();
    }

    @Override
    public OContract getContract() {
        return authName.getContract();
    }

    @Override
    public Date getDelDate() {
        return authName.getDelDate();
    }

    @Override
    public Double getDmId() {
        return authName.getDmId();
    }

    @Override
    public Double getDogBill() {
        return authName.getDogBill();
    }

    @Override
    public Double getDomainId() {
        return authName.getDomainId();
    }

    @Override
    public String getLockAdm() {
        return authName.getLockAdm();
    }

    @Override
    public Double getMakeDmId() {
        return authName.getMakeDmId();
    }

    @Override
    public String getRemark() {
        return authName.getRemark();
    }

    @Override
    public Double getRootDomain() {
        return authName.getRootDomain();
    }

    @Override
    public String getSiteName() {
        return authName.getSiteName();
    }

    @Override
    public Double getTarTypeId() {
        return authName.getTarTypeId();
    }

    @Override
    public Date getWhenMake() {
        return authName.getWhenMake();
    }

    @Override
    public void setBill(Double bill) {
        authName.setBill(bill);
    }

    @Override
    public void setConnectionList(List<OConnection> connectionList) {
        authName.setConnectionList(connectionList);
    }

    @Override
    public void setContract(OContract contract) {
        authName.setContract(contract);
    }

    @Override
    public void setDelDate(Date delDate) {
        authName.setDelDate(delDate);
    }

    @Override
    public void setDmId(Double dmId) {
        authName.setDmId(dmId);
    }

    @Override
    public void setDogBill(Double dogBill) {
        authName.setDogBill(dogBill);
    }

    @Override
    public void setDomainId(Double domainId) {
        authName.setDomainId(domainId);
    }

    @Override
    public void setLockAdm(String lockAdm) {
        authName.setLockAdm(lockAdm);
    }

    @Override
    public void setMakeDmId(Double makeDmId) {
        authName.setMakeDmId(makeDmId);
    }

    @Override
    public void setRemark(String remark) {
        authName.setRemark(remark);
    }

    @Override
    public void setRootDomain(Double rootDomain) {
        authName.setRootDomain(rootDomain);
    }

    @Override
    public void setSiteName(String siteName) {
        authName.setSiteName(siteName);
    }

    @Override
    public void setTarTypeId(Double tarTypeId) {
        authName.setTarTypeId(tarTypeId);
    }

    @Override
    public void setWhenMake(Date whenMake) {
        authName.setWhenMake(whenMake);
    }
}
