package cashArm.onyma.DAO.Adapters;

import cashArm.Common.OEntityes.main.OTariff;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_tm_list_return_row;

import javax.xml.namespace.QName;
import java.util.Calendar;

/**
 * Created by Admin on 20.08.14.
 */
public class ApiRow2OTariff extends OTariff {
    private O_mdb_api_tm_list_return_row row;
    public ApiRow2OTariff(O_mdb_api_tm_list_return_row row){
        this.row=row;
    }

    @Override
    public Double getTmid() {
        return row.getTmid();
    }

    @Override
    public void setTmid(Double tmid) {
        row.setTmid(tmid);
    }

    @Override
    public String getTmname() {
        return row.getTmname();
    }

    @Override
    public void setTmname(String tmname) {
        row.setTmname(tmname);
    }

    @Override
    public Double getGid() {
        return row.getGid();
    }

    @Override
    public void setGid(Double gid) {
        row.setGid(gid);
    }

    @Override
    public Calendar getStart_date() {
        return row.getStart_date();
    }

    @Override
    public void setStart_date(Calendar start_date) {
        row.setStart_date(start_date);
    }

    @Override
    public Calendar getStop_date() {
        return row.getStop_date();
    }

    @Override
    public void setStop_date(Calendar stop_date) {
        row.setStop_date(stop_date);
    }

    @Override
    public Double getTmgid() {
        return row.getTmgid();
    }

    @Override
    public void setTmgid(Double tmgid) {
        row.setTmgid(tmgid);
    }

    @Override
    public String getRemarks() {
        return row.getRemarks();
    }

    @Override
    public void setRemarks(String remarks) {
        row.setRemarks(remarks);
    }

    @Override
    public String getTm_int_name() {
        return row.getTm_int_name();
    }

    @Override
    public void setTm_int_name(String tm_int_name) {
        row.setTm_int_name(tm_int_name);
    }

    @Override
    public Double getTimestamp() {
        return row.getTimestamp();
    }

    @Override
    public void setTimestamp(Double timestamp) {
        row.setTimestamp(timestamp);
    }

    @Override
    public Double getTmidup() {
        return row.getTmidup();
    }

    @Override
    public void setTmidup(Double tmidup) {
        row.setTmidup(tmidup);
    }

    @Override
    public Double getCostlimit() {
        return row.getCostlimit();
    }

    @Override
    public void setCostlimit(Double costlimit) {
        row.setCostlimit(costlimit);
    }

    @Override
    public Double getDogid() {
        return row.getDogid();
    }

    @Override
    public void setDogid(Double dogid) {
        row.setDogid(dogid);
    }

    @Override
    public Double getTime_days() {
        return row.getTime_days();
    }

    @Override
    public void setTime_days(Double time_days) {
        row.setTime_days(time_days);
    }

    @Override
    public Double getNext_tm() {
        return row.getNext_tm();
    }

    @Override
    public void setNext_tm(Double next_tm) {
        row.setNext_tm(next_tm);
    }

    @Override
    public Double getSet_last_tmid() {
        return row.getSet_last_tmid();
    }

    @Override
    public void setSet_last_tmid(Double set_last_tmid) {
        row.setSet_last_tmid(set_last_tmid);
    }

    @Override
    public boolean equals(Object obj) {
        return row.equals(obj);
    }

    @Override
    public int hashCode() {
        return row.hashCode();
    }

}
