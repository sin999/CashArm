package cashArm.Common.OEntityes.main;

import cashArm.Common.OEntityes.ConstantsNew.OResources;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.02.14
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class OConnection  implements Serializable {
    private OAuthName authName;
    private Map<Double,String> parameterMap;
    private List<OPersonalTariff> personalTariffList;
    private OTariff tariff;

    private Double id;              //                              <element name="id" type="xs:double" nillable="true"/>
    private Double dmid;            //  Учетное имя                 <element name="dmid" type="xs:double" nillable="true"/>
    private Double service;         //  Ресурс                      <element name="service" type="xs:double" nillable="true"/>
    private Date startdate;         //  Дата начала                 <element name="startdate" type="xs:dateTime" nillable="true"/>
    private Date enddate;           //  Дата окончания              <element name="enddate" type="xs:dateTime" nillable="true"/>
    private Date startdatetime;     //  Дата/время начала           <element name="startdatetime" type="xs:dateTime" nillable="true"/>
    private Date enddatetime;       //  Дата/время окончания        <element name="enddatetime" type="xs:dateTime" nillable="true"/>
    private Double tmid;            //  Тарифный план               <element name="tmid" type="xs:double" nillable="true"/>
    private Double status;          //  Статус                      <element name="status" type="xs:double" nillable="true"/>
    private String name;            //  Наименование                <element name="name" type="xs:string" nillable="true"/>
    private Double gid;             //  Группa                      <element name="gid" type="xs:double" nillable="true"/>
    private String notes;           //  Примечания                  <element name="notes" type="xs:string" nillable="true"/>
    private Double dogid;           //  Договор                     <element name="dogid" type="xs:double" nillable="true"/>
    private String shared;          //  Область видимости           <element name="shared" type="xs:string" nillable="true"/>
    private Date dadd;              //  Дата добавления             <element name="dadd" type="xs:dateTime" nillable="true"/>
    private String conn_name;       //  Название подключения (из списка подключений) <element name="conn_name" type="xs:string" nillable="true"/>
    private String lastop;          //  Результат последней операции обмена с упр.сервером <element name="lastop" type="xs:string" nillable="true"/>
    private Double status_qualif;   //  Квалификатор изменения статуса <element name="status_qualif" type="xs:double" nillable="true"/>


    public OResources getResource(){
        return OResources.getByCode(getService());
    }

    public OTariff getTariff() {
        return tariff;
    }

    public void setTariff(OTariff tariff) {
        this.tariff = tariff;
    }

    public List<OPersonalTariff> getPersonalTariffList() {
        return personalTariffList;
    }

    public void setPersonalTariffList(List<OPersonalTariff> personalTariffList) {
        this.personalTariffList = personalTariffList;
    }

    public Map<Double, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<Double, String> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public OConnection(OAuthName authName){
        this.authName=authName;
    }

    @XmlTransient
    public OAuthName getAuthName() {
        return authName;
    }

    public void setAuthName(OAuthName authName) {
        this.authName = authName;
    }

    public String getConn_name() {
        return conn_name;
    }

    public void setConn_name(String conn_name) {
        this.conn_name = conn_name;
    }

    public Date getDadd() {
        return dadd;
    }

    public void setDadd(Date dadd) {
        this.dadd = dadd;
    }

    public Double getDmid() {
        return dmid;
    }

    public void setDmid(Double dmid) {
        this.dmid = dmid;
    }

    public Double getDogid() {
        return dogid;
    }

    public void setDogid(Double dogid) {
        this.dogid = dogid;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(Date enddatetime) {
        this.enddatetime = enddatetime;
    }

    public Double getGid() {
        return gid;
    }

    public void setGid(Double gid) {
        this.gid = gid;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getLastop() {
        return lastop;
    }

    public void setLastop(String lastop) {
        this.lastop = lastop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getService() {
        return service;
    }

    public void setService(Double service) {
        this.service = service;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(Date startdatetime) {
        this.startdatetime = startdatetime;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Double getStatus_qualif() {
        return status_qualif;
    }

    public void setStatus_qualif(Double status_qualif) {
        this.status_qualif = status_qualif;
    }

    public Double getTmid() {
        return tmid;
    }

    public void setTmid(Double tmid) {
        this.tmid = tmid;
    }
}
