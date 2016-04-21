package cashArm.onyma.DAO.Adapters;

import ru.onyma.www.services.OnymaApi.types.T_o_mdb_tt_personal_tariff_row;
import cashArm.Common.OEntityes.main.OPersonalTariff;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.02.14
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
public class ApiRow2OPersonalTariffAdapter extends OPersonalTariff implements Serializable {
    private T_o_mdb_tt_personal_tariff_row apiRow;
    public ApiRow2OPersonalTariffAdapter(T_o_mdb_tt_personal_tariff_row apiRow){
        this.apiRow=apiRow;
    }

    @Override
    public Calendar getBegin_date() {
        return apiRow.getBegin_date();
    }

    @Override
    public Double getClsrv() {
        return apiRow.getClsrv();
    }

    @Override
    public Double getCoeff() {
        return apiRow.getCoeff();
    }

    @Override
    public Double getCost() {
        return apiRow.getCost();
    }

    @Override
    public Double getDmid() {
        return apiRow.getDmid();
    }

    @Override
    public Calendar getEnd_date() {
        return apiRow.getEnd_date();
    }

    @Override
    public String getNo_mcost() {
        return apiRow.getNo_mcost();
    }

    @Override
    public String getRemark() {
        return apiRow.getRemark();
    }

    @Override
    public String getServ_alias() {
        return apiRow.getServ_alias();
    }

    @Override
    public Double getServid() {
        return apiRow.getServid();
    }

    @Override
    public Double getTdid() {
        return apiRow.getTdid();
    }

    @Override
    public Double getTmid() {
        return apiRow.getTmid();
    }
}
