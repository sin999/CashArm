package cashArm.Common.OEntityes.main;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.02.14
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class OPersonalTariff  implements Serializable {
//    <sequence>
//    <element name="dmid" type="xs:double" nillable="true"/>
//    <element name="clsrv" type="xs:double" nillable="true"/>
//    <element name="tmid" type="xs:double" nillable="true"/>
//    <element name="servid" type="xs:double" nillable="true"/>
//    <element name="cost" type="xs:double" nillable="true"/>
//    <element name="begin_date" type="xs:dateTime" nillable="true"/>
//    <element name="end_date" type="xs:dateTime" nillable="true"/>
//    <element name="tdid" type="xs:double" nillable="true"/>
//    <element name="coeff" type="xs:double" nillable="true"/>
//    <element name="serv_alias" type="xs:string" nillable="true"/>
//    <element name="remark" type="xs:string" nillable="true"/>
//    <element name="no_mcost" type="xs:string" nillable="true"/>
//    </sequence>

    private Double dmid;
    private Double clsrv;
    private Double tmid;
    private Double servid;
    private Double cost;
    private Calendar begin_date;
    private Calendar end_date;
    private Double tdid;
    private Double coeff;
    private String serv_alias;
    private String remark;
    private String no_mcost;

    public Calendar getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Calendar begin_date) {
        this.begin_date = begin_date;
    }

    public Double getClsrv() {
        return clsrv;
    }

    public void setClsrv(Double clsrv) {
        this.clsrv = clsrv;
    }

    public Double getCoeff() {
        return coeff;
    }

    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getDmid() {
        return dmid;
    }

    public void setDmid(Double dmid) {
        this.dmid = dmid;
    }

    public Calendar getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Calendar end_date) {
        this.end_date = end_date;
    }

    public String getNo_mcost() {
        return no_mcost;
    }

    public void setNo_mcost(String no_mcost) {
        this.no_mcost = no_mcost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getServ_alias() {
        return serv_alias;
    }

    public void setServ_alias(String serv_alias) {
        this.serv_alias = serv_alias;
    }

    public Double getServid() {
        return servid;
    }

    public void setServid(Double servid) {
        this.servid = servid;
    }

    public Double getTdid() {
        return tdid;
    }

    public void setTdid(Double tdid) {
        this.tdid = tdid;
    }

    public Double getTmid() {
        return tmid;
    }

    public void setTmid(Double tmid) {
        this.tmid = tmid;
    }
}
