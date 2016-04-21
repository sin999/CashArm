package cashArm.onyma.DAO.Adapters;

import cashArm.Common.OEntityes.SimplePayment;
import cashArm.Common.OEntityes.main.OContract;
import ru.onyma.www.services.OnymaApi.types.O_mdb_api_dogpayment_return_row;

import java.util.Calendar;

/**
 * Created by Admin on 19.08.14.
 */
public class ApiRow2Payment implements SimplePayment {
    OContract contract;
    private O_mdb_api_dogpayment_return_row row;
    public ApiRow2Payment(O_mdb_api_dogpayment_return_row row){
        this.row=row;
    }

    @Override
    public OContract getDog() {
        return contract;
    }

    @Override
    public String getTxId() {
        return row.getPaydoc();
    }

    @Override
    public Calendar getTxDate() {
        return row.getPpdate();
    }

    @Override
    public Double getTxAmount() {
        return row.getAmount();
    }

    @Override
    public String getComment() {
        return row.getRmrk();
    }
}
