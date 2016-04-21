package cashArm.Common.OEntityes.main;

import java.util.Calendar;

/**
 * Created by Admin on 20.08.14.
 */
public class OTariff {
    //        <complexType name="o_mdb_api_tm_list_return_row">

    private Double tmid;//<element name="tmid" type="xs:double" nillable="true"/>        tmid - Тарифный план
    private String tmname;//    <element name="tmname" type="xs:string" nillable="true"/>      tmname - Назв. тарифного плана
    private Double gid;//    <element name="gid" type="xs:double" nillable="true"/>      gid - Группа
    private Calendar start_date; //    <element name="start_date" type="xs:dateTime" nillable="true"/>      start_date - Дата начала
    private Calendar stop_date; //    <element name="stop_date" type="xs:dateTime" nillable="true"/>     stop_date - Дата окончания
    private Double tmgid;//    <element name="tmgid" type="xs:double" nillable="true"/>     tmgid - Группа тарифных планов
    private String remarks;//    <element name="remarks" type="xs:string" nillable="true"/>    remarks - Комментарий
    private String tm_int_name;//    <element name="tm_int_name" type="xs:string" nillable="true"/>    tm_int_name - Назв. тарифного плана на языке оператора
    private Double timestamp;//    <element name="timestamp" type="xs:double" nillable="true"/>    timestamp - Период действия
    private Double tmidup;//    <element name="tmidup" type="xs:double" nillable="true"/>    tmidup - Переход на тарифный план
    private Double costlimit;//    <element name="costlimit" type="xs:double" nillable="true"/>    costlimit - Услуг на сумму
    private Double dogid;//    <element name="dogid" type="xs:double" nillable="true"/>   dogid - Договор
    private Double time_days;//    <element name="time_days" type="xs:double" nillable="true"/>    time_days - Время жизни
    private Double next_tm;//    <element name="next_tm" type="xs:double" nillable="true"/>    next_tm - Альтернативный ТП для тарификации
    private Double set_last_tmid;//    <element name="set_last_tmid" type="xs:double" nillable="true"/>    set_last_tmid - Переход на предыдущий тарифный план</documentation>

    public Double getTmid() {
        return tmid;
    }

    public void setTmid(Double tmid) {
        this.tmid = tmid;
    }

    public String getTmname() {
        return tmname;
    }

    public void setTmname(String tmname) {
        this.tmname = tmname;
    }

    public Double getGid() {
        return gid;
    }

    public void setGid(Double gid) {
        this.gid = gid;
    }

    public Calendar getStart_date() {
        return start_date;
    }

    public void setStart_date(Calendar start_date) {
        this.start_date = start_date;
    }

    public Calendar getStop_date() {
        return stop_date;
    }

    public void setStop_date(Calendar stop_date) {
        this.stop_date = stop_date;
    }

    public Double getTmgid() {
        return tmgid;
    }

    public void setTmgid(Double tmgid) {
        this.tmgid = tmgid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTm_int_name() {
        return tm_int_name;
    }

    public void setTm_int_name(String tm_int_name) {
        this.tm_int_name = tm_int_name;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTmidup() {
        return tmidup;
    }

    public void setTmidup(Double tmidup) {
        this.tmidup = tmidup;
    }

    public Double getCostlimit() {
        return costlimit;
    }

    public void setCostlimit(Double costlimit) {
        this.costlimit = costlimit;
    }

    public Double getDogid() {
        return dogid;
    }

    public void setDogid(Double dogid) {
        this.dogid = dogid;
    }

    public Double getTime_days() {
        return time_days;
    }

    public void setTime_days(Double time_days) {
        this.time_days = time_days;
    }

    public Double getNext_tm() {
        return next_tm;
    }

    public void setNext_tm(Double next_tm) {
        this.next_tm = next_tm;
    }

    public Double getSet_last_tmid() {
        return set_last_tmid;
    }

    public void setSet_last_tmid(Double set_last_tmid) {
        this.set_last_tmid = set_last_tmid;
    }
}
