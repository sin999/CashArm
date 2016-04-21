package cashArm.Common.OEntityes.main;


import cashArm.Common.OEntityes.SimplePayment;
import cashArm.bbeans.AuthBean;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.12.13
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "OContract")
public class OContract  implements Serializable {
//    <a title="API_DOG_LIST" class="o_menu"  href="javascript:sh_div('stbl3')">Договоры (t2)</a><br>
    public enum Type {
    RASHOD(21.0),
    FIS_LIC(19.0),
    UR_LIC(18.0);
    private Double utid;
    Type(Double utid){
       this.utid=utid;
    }

    public Double getUtid() {
        return utid;
    }
    }
    public enum Status{
        ACTIVE(0.0),INACTIVE(1.0),PAUSED_BY_SYSTEM(2.0),PAUSED_BY_OPERATOR(3.0),CLOSED(4.0);
        private Double statusId;
        Status(Double statusId){
           this.statusId=statusId;
        }

        public double getId() {
            return statusId;
        }
    }
    private List<OAuthName> authNameList= new ArrayList<OAuthName>();
    private Map<Double,OContractAttribute> contractAttributeMap = new HashMap<Double, OContractAttribute>();
    private List<SimplePayment> paymentList=new ArrayList<SimplePayment>();
    private Double balance;


    private Double      dogid ;                 //DOGID t2.Договор
    private Double      dognum;                 //DOGNUM t2.Номер л/с</a>
    private Calendar    startdate;              //STARTDATE t2.Дата начала</a>
    private Calendar    enddate;                //ENDDATE t2.Дата окончания</a>
    private Double      bill;                   //BILL t2.Лицевой счет</a>
    private Double      gid;                    //GID t2.Текущая группа</a>
    private String      dogcode;                //DOGCODE t2.Номер договора</a>
    private Double      status;                 //STATUS t2.Текущий статус</a>
    private Calendar    status_date;            //STATUS_DATE t2.Дата установки статуса</a>
    private Double      orgid;                  //ORGID t2.ID контрагента</a>
    private Double      dogidup;                //DOGIDUP t2.Головной договор</a>
    private Double      parent_orgid;           //PARENT_ORGID t2.ID родительского контрагента</a>
    private Calendar    close_billing_date;     //CLOSE_BILLING_DATE t2.Дата закрытия отчетного периода</a>
    private Double      whomake;                //WHOMAKE t2.Оператор, создавший договор</a>
    private Double      tsid;                   //TSID t2.Налоговая схема</a>
    private Double      csid;                   //CSID t2.Кредитная схема</a>
    private Double      utid;                   //UTID t2.Тип договора</a>

    public OContract(){}
    public OContract(double dogid){
        this.dogid=dogid;
    }

    public List<OConnection> getConnectionList(){
        List<OConnection> connectionList=new ArrayList<OConnection>();
        if(authNameList!=null){
            for(OAuthName authName:authNameList){
                if (authName!=null && authName.getConnectionList()!=null){
                    for(OConnection connection:authName.getConnectionList()){
                        if(connection!=null){
                            connectionList.add(connection);
                        }
                    }
                }
            }
        }
        return connectionList;
    }

    public List<SimplePayment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<SimplePayment> paymentList) {
        this.paymentList = paymentList;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<OAuthName> getAuthNameList() {
        return authNameList;
    }

    public void setAuthNameList(List<OAuthName> authNameList) {
        this.authNameList = authNameList;
    }

    public Double getDogid() {
        return dogid;
    }

    public void setDogid(Double dogid) {
        this.dogid = dogid;
    }

    public Double getDognum() {
        return dognum;
    }

    public void setDognum(Double dognum) {
        this.dognum = dognum;
    }

    public Calendar getStartdate() {
        return startdate;
    }

    public void setStartdate(Calendar startdate) {
        this.startdate = startdate;
    }

    public Calendar getEnddate() {
        return enddate;
    }

    public void setEnddate(Calendar enddate) {
        this.enddate = enddate;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Double getGid() {
        return gid;
    }

    public void setGid(Double gid) {
        this.gid = gid;
    }

    public String getDogcode() {
        return dogcode;
    }

    public void setDogcode(String dogcode) {
        this.dogcode = dogcode;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Calendar getStatus_date() {
        return status_date;
    }

    public void setStatus_date(Calendar status_date) {
        this.status_date = status_date;
    }

    public Double getOrgid() {
        return orgid;
    }

    public void setOrgid(Double orgid) {
        this.orgid = orgid;
    }

    public Double getDogidup() {
        return dogidup;
    }

    public void setDogidup(Double dogidup) {
        this.dogidup = dogidup;
    }

    public Double getParent_orgid() {
        return parent_orgid;
    }

    public void setParent_orgid(Double parent_orgid) {
        this.parent_orgid = parent_orgid;
    }

    public Calendar getClose_billing_date() {
        return close_billing_date;
    }

    public void setClose_billing_date(Calendar close_billing_date) {
        this.close_billing_date = close_billing_date;
    }

    public Double getWhomake() {
        return whomake;
    }

    public void setWhomake(Double whomake) {
        this.whomake = whomake;
    }

    public Double getTsid() {
        return tsid;
    }

    public void setTsid(Double tsid) {
        this.tsid = tsid;
    }

    public Double getCsid() {
        return csid;
    }

    public void setCsid(Double csid) {
        this.csid = csid;
    }

    public Double getUtid() {
        return utid;
    }

    public void setUtid(Double utid) {
        this.utid = utid;
    }

    public Map<Double, OContractAttribute> getContractAttributeMap() {
        return contractAttributeMap;
    }

    public void setContractAttributeMap(Map<Double, OContractAttribute> contractAttributeMap) {
        this.contractAttributeMap = contractAttributeMap;
    }
}
