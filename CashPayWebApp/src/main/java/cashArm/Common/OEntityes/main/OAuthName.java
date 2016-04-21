package cashArm.Common.OEntityes.main;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.02.14
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class OAuthName  implements Serializable {


    private List<OConnection> connectionList = new ArrayList<OConnection>();
    private Double dmId;   //    dmid - Учетное имя                    <element name="dmid" type="xs:double" nillable="true"/>
    private Double domainId;//    domainid - Домен                      <element name="domainid" type="xs:double" nillable="true"/>
    private String siteName;//    sitename - Назв. учетного имени       <element name="sitename" type="xs:string" nillable="true"/>
//    private Double dogId;//    dogid - Договор                       <element name="dogid" type="xs:double" nillable="true"/>
    private Double bill;//    bill - Лицевой счет уч. имени         <element name="bill" type="xs:double" nillable="true"/>
    private String remark;//    remark - Комментарий                  <element name="remark" type="xs:string" nillable="true"/>
    private Double dogBill;//    dogbill - Лицевой счет договора       <element name="dogbill" type="xs:double" nillable="true"/>
    private Double rootDomain;//    rootdomain - Домен (root)             <element name="rootdomain" type="xs:double" nillable="true"/>
    private Date whenMake;//    whenmake - Дата создания              <element name="whenmake" type="xs:dateTime" nillable="true"/>
    private Date delDate;//    deldate - Дата закрытия               <element name="deldate" type="xs:dateTime" nillable="true"/>
    private String lockAdm;//    lockadm - Блокировка на с.с.          <element name="lockadm" type="xs:string" nillable="true"/>
    private Double makeDmId;//    makedmid - Родительское учетно имя    <element name="makedmid" type="xs:double" nillable="true"/>
    private Double tarTypeId;//    tartypeid - Прейскурант               <element name="tartypeid" type="xs:double" nillable="true"/>

    private OContract contract;


    public OAuthName(OContract contract){
        this.contract=contract;
    }
    public OAuthName(OContract contract,String siteName){
        this.siteName=siteName;
    }
    public OAuthName(){
    }

    public List<OConnection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<OConnection> connectionList) {
        this.connectionList = connectionList;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    @XmlTransient
    public OContract getContract() {
        return contract;
    }

    public void setContract(OContract contract) {
        this.contract = contract;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public Double getDmId() {
        return dmId;
    }

    public void setDmId(Double dmId) {
        this.dmId = dmId;
    }

    public Double getDogBill() {
        return dogBill;
    }

    public void setDogBill(Double dogBill) {
        this.dogBill = dogBill;
    }

    public Double getDomainId() {
        return domainId;
    }

    public void setDomainId(Double domainId) {
        this.domainId = domainId;
    }

    public String getLockAdm() {
        return lockAdm;
    }

    public void setLockAdm(String lockAdm) {
        this.lockAdm = lockAdm;
    }

    public Double getMakeDmId() {
        return makeDmId;
    }

    public void setMakeDmId(Double makeDmId) {
        this.makeDmId = makeDmId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getRootDomain() {
        return rootDomain;
    }

    public void setRootDomain(Double rootDomain) {
        this.rootDomain = rootDomain;
    }

    public Double getTarTypeId() {
        return tarTypeId;
    }

    public void setTarTypeId(Double tarTypeId) {
        this.tarTypeId = tarTypeId;
    }

    public Date getWhenMake() {
        return whenMake;
    }

    public void setWhenMake(Date whenMake) {
        this.whenMake = whenMake;
    }
}
